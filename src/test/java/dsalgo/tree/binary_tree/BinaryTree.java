package dsalgo.tree.binary_tree;

import dsalgo.tree.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// bfs --> level order
// dfs --> inorder, preorder, postorder

public class BinaryTree {
    TreeNode root;

    public void insert(int value) {
        TreeNode newNode = new TreeNode(value);
        if (root == null) {
            root = newNode;
            return;
        } else {
            insertNewTreeNode(root, newNode);
        }
    }

    private TreeNode insertNewTreeNode(TreeNode root, TreeNode newNode) {
        if (root == null) {
            return newNode;
        }
        if (newNode.value < root.value) {
            root.left = insertNewTreeNode(root.left, newNode);
        }
        if (newNode.value >= root.value) {
            root.right = insertNewTreeNode(root.right, newNode);
        }
        return root;
    }

    public void traverseLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty"+ " ");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.value + " ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        System.out.println();
    }

    public void traverseInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        traverseInOrder(root.left);
        System.out.print(root.value+ " ");
        traverseInOrder(root.right);
    }

    public void traversePreOrder(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.value+ " ");
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    public void traversePostOrder(TreeNode root){
        if(root == null){
            return;
        }
        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.print(root.value+ " ");
    }

    public boolean search(int value){
        if (root == null){
            return false;
        }
        else if (root.value == value){
            return true;
        }
        return find(root, value);
    }

    private boolean find(TreeNode root, int value) {
        if (root == null){
            return false;
        }
        else if (root.value == value){
            return true;
        }
        if (value<root.value){
            return find(root.left,value);
        } else{
            return find(root.right,value);
        }
    }

    public void mirrorOfTree(TreeNode root){
        if (root == null) {
            return;
        }
        TreeNode tempNode = root.right;
        root.right = root.left;
        root.left = tempNode;
        mirrorOfTree(root.left);
        mirrorOfTree(root.right);
    }
}
