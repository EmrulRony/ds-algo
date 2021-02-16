package dsalgo.tree.avl_tree;

public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        int valueSetLL[] = {40,20,50,10,30,5};

        int activatedSet[] = valueSetLL;

        for (int i = 0 ; i<activatedSet.length; i++){
            avl.add(activatedSet[i]);
        }

        avl.levelOrderTraversal(avl.root);
    }
}
