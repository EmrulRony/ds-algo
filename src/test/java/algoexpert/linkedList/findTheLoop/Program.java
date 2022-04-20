package algoexpert.linkedList.findTheLoop;

public class Program {
    public static LinkedList findLoop(LinkedList head) {
        // Write your code here.
        LinkedList fast = head.next.next;
        LinkedList slow = head.next;
        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
