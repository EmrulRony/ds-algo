package algoexpert.binarySearchTree.kthLargestValue;

import java.util.LinkedList;
import java.util.Queue;

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
        public int currentStep;
        public int currentNodeValue;

        public TreeInfo(int currentStep, int visitedNode) {
            this.currentStep = currentStep;
            this.currentNodeValue = visitedNode;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        TreeInfo treeInfo = new TreeInfo(0, -1);
        findKthLargestValueInBstInternal(tree, treeInfo, k);
        return treeInfo.currentNodeValue;
    }

    private void findKthLargestValueInBstInternal(BST root, TreeInfo treeInfo, int k) {
        if (root == null || k <= treeInfo.currentStep) {
            return;
        }
        findKthLargestValueInBstInternal(root.right, treeInfo, k);
        if (treeInfo.currentStep < k) {
            treeInfo.currentStep += 1;
            treeInfo.currentNodeValue = root.value;
            findKthLargestValueInBstInternal(root.left, treeInfo, k);
        }
    }
}
