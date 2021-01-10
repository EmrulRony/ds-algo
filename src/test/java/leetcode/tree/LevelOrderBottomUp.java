package leetcode.tree;

import leetcode.tree.node.TreeNode;

import java.util.*;

public class LevelOrderBottomUp {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return resultList;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelNodes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                levelNodes.add(tempNode.val);
                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
            }
            resultList.add(levelNodes);
        }
        Collections.reverse(resultList);
        return resultList;
    }

}
