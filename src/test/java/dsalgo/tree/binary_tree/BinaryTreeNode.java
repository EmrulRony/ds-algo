package dsalgo.tree.binary_tree;

public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;
    private int height;

    public BinaryTreeNode(int value) {
        this.value = value;
        this.height = 1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
