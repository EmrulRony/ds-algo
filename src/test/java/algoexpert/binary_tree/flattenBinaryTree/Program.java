package algoexpert.binary_tree.flattenBinaryTree;

import java.util.List;

public class Program {
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        List<BinaryTree> leftAndRightMostNode = getLeftAndRightMostNodes(root);
        return leftAndRightMostNode.get(0);
    }

    private static List<BinaryTree> getLeftAndRightMostNodes(BinaryTree root) {
        BinaryTree leftMostNode;
        BinaryTree rightMostNode;
        if (root.left != null) {
            List<BinaryTree> leftAndRightMostNodes = getLeftAndRightMostNodes(root.left);
            connectNodes(leftAndRightMostNodes.get(1), root);
            leftMostNode = leftAndRightMostNodes.get(0);
        } else {
            leftMostNode = root;
        }

        if (root.right != null) {
            List<BinaryTree> leftAndRightMostNodes = getLeftAndRightMostNodes(root.right);
            connectNodes(root, leftAndRightMostNodes.get(0));
            rightMostNode = leftAndRightMostNodes.get(1);
        } else {
            rightMostNode = root;
        }
        return List.of(leftMostNode, rightMostNode);
    }

    private static void connectNodes(BinaryTree left, BinaryTree right) {
        left.right = right;
        right.left = left;
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}

