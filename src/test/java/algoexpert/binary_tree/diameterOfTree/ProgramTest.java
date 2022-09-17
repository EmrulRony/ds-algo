package algoexpert.binary_tree.diameterOfTree;

import org.junit.Test;

import java.util.ArrayDeque;

import static org.junit.Assert.assertTrue;

public class ProgramTest {
    @Test
    public void TestCase1() {
        TestBinaryTree input = new TestBinaryTree(1);
        input.insert(new int[] {2, 3, 4, 5, 6, 7}, 0);
        var expected = 4;
        var actual = new Program().binaryTreeDiameter(input);
        assertTrue(expected == actual);
    }

    class TestBinaryTree extends Program.BinaryTree {
        public TestBinaryTree(int value) {
            super(value);
        }

        public void insert(int[] values, int i) {
            if (i >= values.length) {
                return;
            }
            ArrayDeque<Program.BinaryTree> queue = new ArrayDeque<Program.BinaryTree>();
            queue.addLast(this);
            while (queue.size() > 0) {
                Program.BinaryTree current = queue.pollFirst();
                if (current.left == null) {
                    current.left = new Program.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.left);
                if (current.right == null) {
                    current.right = new Program.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.right);
            }
            insert(values, i + 1);
        }
    }
}
