package algoexpert.binarySearchTree.validateBST;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProgramTest {
    @Test
    public void TestCase1() {
        var root = new Program.BST(10);
        root.left = new Program.BST(5);
        root.left.left = new Program.BST(2);
        root.left.left.left = new Program.BST(1);
        root.left.right = new Program.BST(5);
        root.right = new Program.BST(15);
        root.right.left = new Program.BST(13);
        root.right.left.right = new Program.BST(14);
        root.right.right = new Program.BST(22);

        assertTrue(Program.validateBst(root));
    }
}
