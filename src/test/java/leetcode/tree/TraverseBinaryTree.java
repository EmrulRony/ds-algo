package leetcode.tree;

import leetcode.tree.node.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraverseBinaryTree {
    public List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> resultList = new LinkedList<>();
        if (root == null){
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            resultList.add(temp.val);
            if (temp.left != null){
                queue.add(temp.left);
            }

            if (temp.right != null){
                queue.add(temp.right);
            }
        }
        return resultList;
    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> resultList = new LinkedList<>();
        if (root == null){
            return resultList;
        }
        traverse(root,resultList);
        return resultList;
    }

    private void traverse(TreeNode root, List<Integer> resultList) {
        if (root == null)
            return;
        traverse(root.left, resultList);
        resultList.add(root.val);
        traverse(root.right, resultList);
    }
}
