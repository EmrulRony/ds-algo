package algoexpert.binary_tree.maxPathSum;

public class Program {
    public static int maxPathSum(BinaryTree tree) {
        TreeData treeData = getTreeData(tree);
        return treeData.maxPathSum;
    }

    private static TreeData getTreeData(BinaryTree node) {
        if (node == null) {
            return new TreeData(0, Integer.MIN_VALUE);
        }
        TreeData leftSubTreeData = getTreeData(node.left);
        TreeData rightSubTreeData = getTreeData(node.right);
        int maxChildBranchPath = Math.max(leftSubTreeData.sumAsBranch, rightSubTreeData.sumAsBranch);
        int maxChildBranchPathIncludingRoot = Math.max(maxChildBranchPath + node.value, node.value);
        int maxTriangularPathSum = Math.max(maxChildBranchPathIncludingRoot, leftSubTreeData.sumAsBranch + node.value + rightSubTreeData.sumAsBranch);
        int maxPathSum = Math.max(leftSubTreeData.maxPathSum, Math.max(rightSubTreeData.maxPathSum, maxTriangularPathSum));
        return new TreeData(maxChildBranchPathIncludingRoot, maxPathSum);
    }

    private static class TreeData {
        int sumAsBranch;
        int maxPathSum;

        public TreeData(int sumAsBranch, int pathSum) {
            this.sumAsBranch = sumAsBranch;
            this.maxPathSum = pathSum;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}

