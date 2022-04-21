package algoexpert.linkedList.reverseLinkedList;

public class Program {
    // My first try
//    public static LinkedList reverseLinkedList(LinkedList head) {
//        // Write your code here.
//        LinkedList firstPointer = head.next;
//        LinkedList secondPointer = head;
//        secondPointer.next = null;
//        while (firstPointer != null) {
//            LinkedList tempFirst = firstPointer;
//            LinkedList tempSecond = secondPointer;
//            secondPointer = firstPointer;
//            firstPointer = firstPointer.next;
//            tempFirst.next = tempSecond;
//        }
//        return secondPointer;
//    }


    // A better one
    public static LinkedList reverseLinkedList(LinkedList head) {
        // Write your code here.
        LinkedList currentNode = head;
        LinkedList prevNode = null;
        while (currentNode != null) {
            LinkedList nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
