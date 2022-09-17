package algoexpert.binary_tree.diameterOfTree;

public class Program {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        return getTreeDiameterAndHeight(tree, new int[2])[0];
    }

    private int[] getTreeDiameterAndHeight(BinaryTree tree, int[] arr) {
        if (tree == null) {
            return new int[]{0, 0};
        }
        int[] leftSubTreeInfo = getTreeDiameterAndHeight(tree.left, arr);
        int[] rightSubTreeInfo = getTreeDiameterAndHeight(tree.right, arr);
        int lengthThroughNode = leftSubTreeInfo[1] + rightSubTreeInfo[1];
        int maxDiameterSoFar = Math.max(leftSubTreeInfo[0], rightSubTreeInfo[0]);
        int diameterOfTheTree = Math.max(maxDiameterSoFar, lengthThroughNode);
        int currentTreeHeight = Math.max(leftSubTreeInfo[1], rightSubTreeInfo[1]);
        return (new int[]{diameterOfTheTree, currentTreeHeight+1});
    }
}
