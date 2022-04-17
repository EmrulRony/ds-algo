package algoexpert.linkedList.removeKthNodeFromEnd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ProgramTest {
    @Test
    public void TestCase1() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        Program.removeKthNodeFromEnd(test, 4);
        assertTrue(compare(test.getNodesInArray(), expected));
    }

    public boolean compare(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    class TestLinkedList extends Program.LinkedList {

        public TestLinkedList(int value) {
            super(value);
        }

        public void addMany(int[] values) {
            Program.LinkedList current = this;
            while (current.next != null) {
                current = current.next;
            }
            for (int value : values) {
                current.next = new Program.LinkedList(value);
                current = current.next;
            }
        }

        public List<Integer> getNodesInArray() {
            List<Integer> nodes = new ArrayList<Integer>();
            Program.LinkedList current = this;
            while (current != null) {
                nodes.add(current.value);
                current = current.next;
            }
            return nodes;
        }
    }
}
