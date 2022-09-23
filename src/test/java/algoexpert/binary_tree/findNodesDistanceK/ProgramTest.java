package algoexpert.binary_tree.findNodesDistanceK;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class ProgramTest {
    @Test
    public void TestCase1() {

        Program.BinaryTree root = new Program.BinaryTree(1);
        root.left = new Program.BinaryTree(2);
        root.right = new Program.BinaryTree(3);
        root.left.left = new Program.BinaryTree(4);
        root.left.right = new Program.BinaryTree(5);
        root.right.right = new Program.BinaryTree(6);
        root.right.right.left = new Program.BinaryTree(7);
        root.right.right.right = new Program.BinaryTree(8);
        int target = 3;
        int k = 2;
        var expected = new ArrayList<Integer>(Arrays.asList(2, 7, 8));
        var actual = new Program().findNodesDistanceK(root, target, k);
        Collections.sort(actual);
        assertTrue(expected.equals(actual));
    }
}
