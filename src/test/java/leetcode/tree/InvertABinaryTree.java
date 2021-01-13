package leetcode.tree;

import leetcode.tree.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertABinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return  null;
        } else if (root.left == null && root.right == null){
            return root;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while(!treeNodes.isEmpty()){
            TreeNode currNode = treeNodes.poll();
            TreeNode tempNode = currNode.right;
            currNode.right = currNode.left;
            currNode.left = tempNode;
            if (currNode.left != null){
                treeNodes.add(currNode.left);
            }
            if (currNode.right != null){
                treeNodes.add(currNode.right);
            }
        }
        return root;
    }
}
