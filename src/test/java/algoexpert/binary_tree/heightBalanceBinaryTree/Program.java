package algoexpert.binary_tree.heightBalanceBinaryTree;

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

    private static class TreeData {
        public int height;
        public boolean isBalance;

        public TreeData(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        TreeData treeData = getTreeData(tree);
        return treeData.isBalance;
    }

    private TreeData getTreeData(BinaryTree tree) {
        if (tree == null) {
            return new TreeData(-1, false);
        }
        TreeData leftSubTreeData = getTreeData(tree.left);
        TreeData rightSubTreeData = getTreeData(tree.right);
        int heightDiff = Math.abs(leftSubTreeData.height - rightSubTreeData.height);
        int height = Math.max(leftSubTreeData.height, rightSubTreeData.height) + 1;
        boolean isBalance = leftSubTreeData.isBalance && rightSubTreeData.isBalance && heightDiff <= 1;
        return new TreeData(height, isBalance);
    }
}
