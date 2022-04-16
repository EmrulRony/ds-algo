package algoexpert.linkedList.removeDuplicates;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProgramTest {
    public Program.LinkedList addMany(Program.LinkedList ll, List<Integer> values) {
        Program.LinkedList current = ll;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new Program.LinkedList(value);
            current = current.next;
        }
        return ll;
    }

    public List<Integer> getNodesInArray(Program.LinkedList ll) {
        List<Integer> nodes = new ArrayList<Integer>();
        Program.LinkedList current = ll;
        while (current != null) {
            nodes.add(current.value);
            current = current.next;
        }
        return nodes;
    }

    @Test
    public void TestCase1() {
        Program.LinkedList input = new Program.LinkedList(1);
        addMany(input, new ArrayList<Integer>(Arrays.asList(1, 3, 4, 4, 4, 5, 6, 6)));
        List<Integer> expectedNodes = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5, 6));
        Program.LinkedList output = new Program().removeDuplicatesFromLinkedList(input);
        assertEquals(getNodesInArray(output), expectedNodes);
    }
}