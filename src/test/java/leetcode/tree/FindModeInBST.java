package leetcode.tree;

import leetcode.tree.node.TreeNode;

import java.util.*;

public class FindModeInBST {
    int count = 1;
    int max = 0;
    Integer prev = null;
    public int[] findMode(TreeNode root) {
        List<Integer> resultList = new LinkedList<>();
        inOrder(root,resultList);
        int[] resultArr = resultList.stream().mapToInt(Integer::intValue)
                .toArray();
        return resultArr;
    }
    private void inOrder(TreeNode root, List<Integer> resultList){
        if (root == null){
            return;
        }
        inOrder(root.left,resultList);
        if (prev != null){
            if (prev == root.val){
                count++;
            } else {
                count = 1;
            }
        }

        if (count > max){
            max = count;
            resultList.clear();
            resultList.add(root.val);
        } else if (count == max){
            resultList.add(root.val);
        }

        prev = root.val;
        inOrder(root.right, resultList);
    }
}
