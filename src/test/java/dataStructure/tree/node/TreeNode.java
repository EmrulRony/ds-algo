package dataStructure.tree.node;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    public int height;

    public TreeNode (int value){
        this.value = value;
        this.height = 1;
    }
}
