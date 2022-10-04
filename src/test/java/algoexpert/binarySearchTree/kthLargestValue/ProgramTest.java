package algoexpert.binarySearchTree.kthLargestValue;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProgramTest {
    @Test
    public void TestCase1() {
        Program.BST root = new Program.BST(15);
        root.left = new Program.BST(5);
        root.left.left = new Program.BST(2);
        root.left.left.left = new Program.BST(1);
        root.left.left.right = new Program.BST(3);
        root.left.right = new Program.BST(5);
        root.right = new Program.BST(20);
        root.right.left = new Program.BST(17);
        root.right.right = new Program.BST(22);
        int k = 3;
        int expected = 17;
        var actual = new Program().findKthLargestValueInBst(root, k);
        assertTrue(expected == actual);
    }
}