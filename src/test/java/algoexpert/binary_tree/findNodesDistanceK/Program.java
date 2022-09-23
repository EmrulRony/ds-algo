package algoexpert.binary_tree.findNodesDistanceK;

import java.util.*;

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

    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        if (tree == null) {
            return new ArrayList<>();
        }
        Map<Integer, BinaryTree> parentNodeMap = new HashMap<>();
        updateParentNodes(tree, null, parentNodeMap);
        BinaryTree targetNode = getTargetNode(tree, target, parentNodeMap);
        return getKDistanceNodes(tree, targetNode, k, parentNodeMap);
    }

    private ArrayList<Integer> getKDistanceNodes(BinaryTree tree, BinaryTree targetNode, int targetDistance,
                                                 Map<Integer, BinaryTree> parentNodeMap)
    {
        Queue<Map<BinaryTree, Integer>> queue = new LinkedList<>();
        queue.add(Map.of(targetNode, 0));
        ArrayList<Integer> resultNodes = new ArrayList<>();
        List<Integer> visitedNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            Map<BinaryTree, Integer> currentNodeMap = queue.poll();
            Map.Entry<BinaryTree, Integer> entry = currentNodeMap.entrySet().iterator().next();
            BinaryTree currentNode = entry.getKey();
            Integer currentNodeDistance = entry.getValue();
            if (currentNodeDistance == targetDistance) {
                resultNodes.add(currentNode.value);
                queue.forEach(node -> resultNodes.add(node.keySet().iterator().next().value));
                return resultNodes;
            }
            visitedNodes.add(currentNode.value);
            if (currentNode.left != null && !visitedNodes.contains(currentNode.left.value)) {
                queue.add(Map.of(currentNode.left, currentNodeDistance + 1));
            }
            if (currentNode.right != null && !visitedNodes.contains(currentNode.right.value)) {
                queue.add(Map.of(currentNode.right, currentNodeDistance + 1));
            }
            BinaryTree parentNode = parentNodeMap.get(currentNode.value);
            if (parentNode != null && !visitedNodes.contains(parentNode.value)) {
                queue.add(Map.of(parentNode, currentNodeDistance + 1));
            }
        }
        return resultNodes;
    }

    private BinaryTree getTargetNode(BinaryTree node, int target, Map<Integer, BinaryTree> parentNodeMap) {
        if (node.value == target) {
            return node;
        }
        BinaryTree parentNode = parentNodeMap.get(target);
        if (parentNode.left != null && parentNode.left.value == target) {
            return parentNode.left;
        }
        return parentNode.right;
    }

    private void updateParentNodes(BinaryTree node, BinaryTree parentNode, Map<Integer, BinaryTree> parentNodeMap) {
        if (node != null) {
            parentNodeMap.put(node.value, parentNode);
            updateParentNodes(node.left, node, parentNodeMap);
            updateParentNodes(node.right, node, parentNodeMap);
        }
    }
}
