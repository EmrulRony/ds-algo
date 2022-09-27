package dataStructure.tree.avl_tree;

import dataStructure.tree.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//T1, T2, T3 and T4 are subtrees.
//        z                                        y
//        / \                                    /    \
//        y   T4      Right Rotate (z)          x      z
//        / \          - - - - - - - - ->      /  \    / \
//        x   T3                               T1  T2  T3 T4
//        / \
//        T1   T2

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
        if (balanceFactor > 1 && root.left.value > value){
            root = rightRotate(root);
        } else if (balanceFactor > 1 && root.left.value < value){
            root.left = leftRotate(root.left);
            root = rightRotate(root);
        } else if (balanceFactor < -1 && value > root.right.value){
            root = leftRotate(root);
        } else if (balanceFactor < -1 && value < root.right.value){
            root.right = rightRotate(root.right);
            root = leftRotate(root);
        }
        return root;
    }

    private TreeNode leftRotate(TreeNode currNode) {
        TreeNode newRoot = currNode.right;
        currNode.right = currNode.right.left;
        newRoot.left = currNode;
        newRoot.height = Math.max(getNodeHeight(newRoot.left), getNodeHeight(newRoot.right));
        currNode.height = Math.max(getNodeHeight(currNode.left), getNodeHeight(currNode.right));
        return newRoot;
    }

    private TreeNode rightRotate(TreeNode currNode) {
        TreeNode newRoot = currNode.left;
        currNode.left = currNode.left.right;
        newRoot.right = currNode;
        newRoot.height = Math.max(getNodeHeight(newRoot.left), getNodeHeight(newRoot.right));
        currNode.height = Math.max(getNodeHeight(currNode.left), getNodeHeight(currNode.right));
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
