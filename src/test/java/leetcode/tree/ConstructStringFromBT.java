package leetcode.tree;

import leetcode.tree.node.TreeNode;

public class ConstructStringFromBT {
    public String tree2str(TreeNode t) {
        StringBuilder resultBuilder = new StringBuilder();
        inOrderTraverse(resultBuilder, t);
        return resultBuilder.toString();
    }

    private void inOrderTraverse(StringBuilder resultBuilder, TreeNode node) {
        if(node == null) return;
        resultBuilder.append(node.val);
        resultBuilder.append("(");
        inOrderTraverse(resultBuilder,node.left);
        resultBuilder.append(")");
        if (node.right != null){
            resultBuilder.append("(");
            inOrderTraverse(resultBuilder, node.right);
            resultBuilder.append(")");
        }
    }
}
