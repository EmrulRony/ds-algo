package leetcode.tree;

import leetcode.tree.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBT {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resultList = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            double sum = 0;
            int size = nodes.size();
            for (int i = 0; i<size; i++){
                TreeNode currNode = nodes.poll();
                sum += currNode.val;
                if (currNode.left != null) nodes.add(currNode.left);
                if (currNode.right != null) nodes.add(currNode.right);
            }
            resultList.add(sum/size);
        }
        return resultList;
    }
}
