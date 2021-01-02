package dsalgo.tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] nums = {100,20,500,10,30,40};
        for (Integer i : nums){
            bt.insert(i);
        }
        bt.traverseLevelOrder(bt.root);
    }
}
