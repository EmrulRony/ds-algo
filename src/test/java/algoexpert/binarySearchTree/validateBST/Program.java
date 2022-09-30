package algoexpert.binarySearchTree.validateBST;

public class Program {
    public static boolean validateBst(BST tree) {
        return validateBstInternal(tree, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private static boolean validateBstInternal(BST root, int maxValue, int minValue) {
        if (root == null) {
            return true;
        }
        if (!(root.value < maxValue) || !(root.value >= minValue)) {
            return false;
        }
        if (root.left != null && !validateBstInternal(root.left, root.value, minValue)) {
            return false;
        } else if (root.right != null && !validateBstInternal(root.right, maxValue, root.value)) {
            return false;
        }
        return true;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
