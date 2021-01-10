package dsalgo.tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] nums = {100,20,500,10,30,40};
        for (Integer i : nums){
            bt.insert(i);
        }
        System.out.println("Traversing level order");
        System.out.println();
        bt.traverseLevelOrder(bt.root);
        System.out.println("Traversing in-order");

        bt.traverseInOrder(bt.root);
        System.out.println();
        System.out.println("Traversing post-order");

        bt.traversePostOrder(bt.root);
        System.out.println();
        System.out.println("Traversing pre-order");

        bt.traversePreOrder(bt.root);
        System.out.println();

        System.out.println("Searching a node in binary tree");
        boolean result = bt.search(5000);
        System.out.println(result);

        bt.mirrorOfTree(bt.root);
        bt.traverseLevelOrder(bt.root);
    }
}
