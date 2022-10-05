package algoexpert.binarySearchTree.reconstructBst;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ProgramTest {

    public List<Integer> getDfsOrder(Program.BST node, List<Integer> values) {
        values.add(node.value);
        if (node.left != null) {
            getDfsOrder(node.left, values);
        }
        if (node.right != null) {
            getDfsOrder(node.right, values);
        }
        return values;
    }

    @Test
    public void TestCase1() {
        List<Integer> preOrderTraversalValues =
                new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 3, 17, 19, 18));
        Program.BST tree = new Program.BST(10);
        tree.left = new Program.BST(4);
        tree.left.left = new Program.BST(2);
        tree.left.left.left = new Program.BST(1);
        tree.left.right = new Program.BST(3);
        tree.right = new Program.BST(17);
        tree.right.right = new Program.BST(19);
        tree.right.right.left = new Program.BST(18);
        List<Integer> expected = getDfsOrder(tree, new ArrayList<Integer>());
        var actual = new Program().reconstructBst(preOrderTraversalValues);
        List<Integer> actualValues = getDfsOrder(actual, new ArrayList<Integer>());
        assertTrue(expected.equals(actualValues));
    }
}
