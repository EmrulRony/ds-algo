package algoexpert.binarySearchTree.reconstructBst;

import java.util.ArrayList;
import java.util.List;

public class Program {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public int idx;

        public TreeInfo(int idx) {
            this.idx = idx;
        }
    }

    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        // Write your code here.
        TreeInfo treeInfo = new TreeInfo(0);
        return reconstructBstInternal(treeInfo, preOrderTraversalValues, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private BST reconstructBstInternal(TreeInfo treeInfo, List<Integer> preOrderTraversalValues, int maxVal, int minVal) {
        BST root = null;
        int idx = treeInfo.idx;
        if (idx >= preOrderTraversalValues.size()) {
            return null;
        }
        int valueToBeInserted = preOrderTraversalValues.get(idx);
        if ((valueToBeInserted == minVal) && (valueToBeInserted < maxVal)) {
            treeInfo.idx += 1;
            root = new BST(valueToBeInserted);
        } else {
            return null;
        }
        root.left = reconstructBstInternal(treeInfo, preOrderTraversalValues, root.value, minVal);
        root.right = reconstructBstInternal(treeInfo, preOrderTraversalValues, maxVal, root.value);
        return root;
    }
}
