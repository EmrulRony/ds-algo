package algoexpert.binarySearchTree.closestNode;

public class Program {
    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBstInternal(tree, target, tree.value);
    }

    private static int findClosestValueInBstInternal(BST root, int target, int closestNode) {
        if (Math.abs(root.value - target) < Math.abs(closestNode - target)) {
            closestNode = root.value;
        }
        if (target < root.value && root.left != null) {
            return findClosestValueInBstInternal(root.left, target, closestNode);
        } else if (target > root.value && root.right != null) {
            return findClosestValueInBstInternal(root.right, target, closestNode);
        }
        return closestNode;
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
