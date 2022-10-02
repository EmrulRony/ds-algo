package algoexpert.binary_tree.BSTConstruct;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProgramTest {
    @Test
    public void TestCase1() {
        var root = new Program.BST(10);
        root.left = new Program.BST(5);
//        root.left.left = new Program.BST(2);
//        root.left.left.left = new Program.BST(1);
//        root.left.right = new Program.BST(5);
//        root.right = new Program.BST(15);
//        root.right.left = new Program.BST(13);
//        root.right.left.right = new Program.BST(14);
//        root.right.right = new Program.BST(22);

//        root.insert(12);
//        assertEquals(12, root.right.left.left.value);

        root = root.remove(10);
        assertTrue(root.contains(10) == false);
//        assertTrue(root.value == 12);

//        assertTrue(root.contains(15));
    }
}
