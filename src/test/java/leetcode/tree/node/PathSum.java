package leetcode.tree.node;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        treeNodes.add(root);
        sumQueue.add(sum- root.val);
        while (!treeNodes.isEmpty()){
            TreeNode currentNode = treeNodes.poll();
            Integer currentSum = sumQueue.poll();
            if (currentNode.left == null && currentNode.right == null && currentSum == 0){
                return true;
            }
            if (currentNode.left != null){
                treeNodes.add(currentNode.left);
                sumQueue.add(currentSum - currentNode.left.val);
            }

            if (currentNode.right != null){
                treeNodes.add(currentNode.right);
                sumQueue.add(currentSum - currentNode.right.val);
            }
        }
        return false;
    }
}
