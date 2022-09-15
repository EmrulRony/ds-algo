package algoexpert.binary_tree.invert_bt;

public class Program {
    public static void invertBinaryTree(BinaryTree tree) {
        if (tree != null) {
            swapChilds(tree);
            invertBinaryTree(tree.left);
            invertBinaryTree(tree.right);
        }
    }

    private static void swapChilds(BinaryTree tree) {
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
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

