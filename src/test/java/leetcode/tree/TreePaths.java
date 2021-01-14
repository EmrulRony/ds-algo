package leetcode.tree;

import leetcode.tree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        if (root == null){
            return resultList;
        }
        String currentPath = String.valueOf(root.val);
        if (root.left == null && root.right == null){
            resultList.add(currentPath);
            return resultList;
        }
        if (root.left != null){
            dfs(root.left, currentPath, resultList);
        }
        if (root.right != null){
            dfs(root.right, currentPath, resultList);
        }
        return resultList;
    }

    private void dfs(TreeNode root, String currentPath, List<String> resultList) {
        currentPath = currentPath.concat("->" + root.val);
        if (root.left == null && root.right == null){
            resultList.add(currentPath);
            return;
        }
        if (root.left != null){
            dfs(root.left, currentPath, resultList);
        }
        if (root.right != null){
            dfs(root.right, currentPath, resultList);
        }
    }
}
