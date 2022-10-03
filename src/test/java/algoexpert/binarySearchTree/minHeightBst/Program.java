package algoexpert.binarySearchTree.minHeightBst;

import java.util.List;

public class Program {
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        return constructMinHeightBst(null, array, 0, array.size() - 1);
    }

    public static BST constructMinHeightBst(BST root, List<Integer> array, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        if (root == null) {
            root = new BST(array.get(mid));
        } else {
            root.insert(array.get(mid));
        }
        constructMinHeightBst(root, array, left, mid - 1);
        constructMinHeightBst(root, array, mid + 1, right);
        return root;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}

