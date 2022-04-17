package algoexpert.linkedList.removeKthNodeFromEnd;

public class Program {
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        LinkedList firstPointer = head;
        LinkedList secondPointer = head;
        int counter = 1;
        while (counter <= k) {
            firstPointer = firstPointer.next;
            counter++;
        }
        if (firstPointer == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        while (firstPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        secondPointer.next = secondPointer.next.next;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
