package algoexpert.binary_tree.iterativeInOrderTraversal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ProgramTest {
    public List<Integer> testArray = new ArrayList<Integer>();

    public Void testCallback(Program.BinaryTree tree) {
        if (tree == null) {
            return null;
        }
        testArray.add(tree.value);
        return null;
    }

    @Test
    public void TestCase1() {
        var root = new Program.BinaryTree(1);
        root.left = new Program.BinaryTree(2, root);
        root.left.left = new Program.BinaryTree(4, root.left);
        root.left.left.right = new Program.BinaryTree(9, root.left.left);
        root.right = new Program.BinaryTree(3, root);
        root.right.left = new Program.BinaryTree(6, root.right);
        root.right.right = new Program.BinaryTree(7, root.right);

        this.testArray.clear();
        Program.iterativeInOrderTraversal(root, this::testCallback);
        List<Integer> expected = Arrays.asList(new Integer[] {4, 9, 2, 1, 6, 3, 7});
        assertTrue(expected.equals(this.testArray));
    }
}
