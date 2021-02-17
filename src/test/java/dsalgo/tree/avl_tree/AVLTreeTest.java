package dsalgo.tree.avl_tree;

public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        int valueSetLL[] = {40,20,50,10,30,5};
        int valueSetLR[] = {40,30,50,20,25};
        int valueSetRR[] = {40,30,60,50,70,80};
        int valueSetRL[] = {40,30,50,60,55};

        int activatedSet[] = valueSetRL;

        for (int i = 0 ; i<activatedSet.length; i++){
            avl.add(activatedSet[i]);
        }

        avl.levelOrderTraversal(avl.root);
    }
}
