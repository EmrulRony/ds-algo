package algoexpert.linkedList.addTwoNumbers;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ProgramTest {
    @Test
    public void TestCase1() {
        Program.LinkedList ll1 = addMany(new Program.LinkedList(2), new int[] {4, 7, 1});
        Program.LinkedList ll2 = addMany(new Program.LinkedList(9), new int[] {4, 5});
        Program.LinkedList expected = addMany(new Program.LinkedList(1), new int[] {9, 2, 2});
        var actual = new Program().sumOfLinkedLists(ll1, ll2);
        assertEquals(getNodesInArray(expected), getNodesInArray(actual));
    }

    public Program.LinkedList addMany(Program.LinkedList linkedList, int[] values) {
        var current = linkedList;
        while (current.next != null) {
            current = current.next;
        }
        for (var value : values) {
            current.next = new Program.LinkedList(value);
            current = current.next;
        }
        return linkedList;
    }

    public ArrayList<Integer> getNodesInArray(Program.LinkedList linkedList) {
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        Program.LinkedList current = linkedList;
        while (current != null) {
            nodeValues.add(current.value);
            current = current.next;
        }
        return nodeValues;
    }
}
