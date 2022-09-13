package algoexpert.binary_tree.node_depth;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProgramTest {
    @Test
    public void TestCase1() {
        var root = new Program.BinaryTree(1);
        root.left = new Program.BinaryTree(2);
        root.left.left = new Program.BinaryTree(4);
        root.left.left.left = new Program.BinaryTree(8);
        root.left.left.right = new Program.BinaryTree(9);
        root.left.right = new Program.BinaryTree(5);
        root.right = new Program.BinaryTree(3);
        root.right.left = new Program.BinaryTree(6);
        root.right.right = new Program.BinaryTree(7);
        int actual = Program.nodeDepths(root);
        assertEquals(16, actual);
    }
}