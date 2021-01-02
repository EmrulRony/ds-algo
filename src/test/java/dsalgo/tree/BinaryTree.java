package dsalgo.tree;

import dsalgo.tree.node.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

// bfs --> level order
// dfs --> inorder, preorder, postorder

public class BinaryTree {
    TreeNode root;

    public void insert(int value) {
        TreeNode newNode = new TreeNode(value);
        if (root == null){
            root = newNode;
            return;
        } else {
            inserNewTreeNode(root,newNode);
        }
    }
    private TreeNode inserNewTreeNode(TreeNode root, TreeNode newNode){
        if (root == null){
            return newNode;
        }
        if (newNode.value < root.value){
            root.left = inserNewTreeNode(root.left, newNode);
        }
        if (newNode.value >= root.value){
            root.right = inserNewTreeNode(root.right, newNode);
        }
        return root;
    }

     public void traverseLevelOrder(TreeNode root){
        if (root == null){
            System.out.println("Tree is empty");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode tempNode = queue.poll();
            System.out.println(tempNode.value);
            if (tempNode.left != null){
                queue.add(tempNode.left);
            }
            if (tempNode.right != null){
                queue.add(tempNode.right);
            }
        }
     }

     @Test
    public void insertionTest(){
        BinaryTree bt = new BinaryTree();
        int[] nums = {100,20,500,10,30,40};
        for (Integer i : nums){
            bt.insert(i);
        }
     }
}
