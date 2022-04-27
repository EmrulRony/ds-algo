package algoexpert.linkedList.shiftLinkedList;

public class Program {
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        // Write your code here.
        int length = 1;
        LinkedList tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
            length++;
        }
        int offset = Math.abs(k) % length;
        if (offset == 0) {
            return head;
        }
        int newTailPosition = k > 0 ? length - offset : offset;
        LinkedList newTail = head;
        for (int i = 0; i < newTailPosition - 1; i++) {
            newTail = newTail.next;
        }
        LinkedList newHead = newTail.next;
        newTail.next = null;
        tailNode.next = head;
        return newHead;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}
