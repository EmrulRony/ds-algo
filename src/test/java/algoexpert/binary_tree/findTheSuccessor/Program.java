package algoexpert.binary_tree.findTheSuccessor;

public class Program {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        if (tree == null) {
            return null;
        }
        if (node.right != null) {
            return getLeftMostNode(node.right);
        }
        return getSucccessorInAncestors(node);
    }

    private BinaryTree getSucccessorInAncestors(BinaryTree node) {
        BinaryTree currentNode = node;
        while (currentNode.parent != null && currentNode.parent.right == currentNode) {
            currentNode = currentNode.parent;
        }
        return currentNode.parent;
    }

    private BinaryTree getLeftMostNode(BinaryTree node) {
        BinaryTree currentNode = node;
        if (node.left != null) {
            currentNode = getLeftMostNode(node.left);
        }
        return currentNode;
    }
}

