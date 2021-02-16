package dsalgo.tree.avl_tree;

import dsalgo.tree.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    TreeNode root;

    // inserting values into tree
    public void add(int value) {
        if (root == null) {
            this.root = new TreeNode(value);
        } else {
            this.root = insertIntoAVLTree(this.root, value);
        }
    }

    private TreeNode insertIntoAVLTree(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        else if (value < root.value) {
            root.left = insertIntoAVLTree(root.left, value);
        } else if (value > root.value) {
            root.right = insertIntoAVLTree(root.right, value);
        }
        root.height = Math.max(getNodeHeight(root.left), getNodeHeight(root.right)) + 1;
        int balanceFactor = Math.subtractExact(getNodeHeight(root.left),getNodeHeight(root.right));
        if (balanceFactor > 1 && root.value > value){
            root = leftLeftRotate(root);
        }
        return root;
    }

    private TreeNode leftLeftRotate(TreeNode currNode) {
        TreeNode newRoot = currNode.left;
        currNode.left = currNode.left.right;
        newRoot.right = currNode;
        return newRoot;
    }

    private int getNodeHeight(TreeNode node) {
        if (node == null) return 0;
        else {
            return node.height;
        }
    }

    public void levelOrderTraversal(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode currNode = nodes.poll();
            System.out.print(currNode.value + " ");
            if (currNode.left != null) nodes.add(currNode.left);
            if (currNode.right != null) nodes.add(currNode.right);
        }
    }
}
