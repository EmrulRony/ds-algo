package algoexpert.linkedList.mergeLinkedList;

public class Program {
    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.
        LinkedList pointerOne = headOne;
        LinkedList pointerTwo = headTwo;
        LinkedList prevNode = null;
        while (pointerOne != null && pointerTwo != null) {
            if (pointerOne.value < pointerTwo.value) {
                prevNode = pointerOne;
                pointerOne = pointerOne.next;
            } else {
                if (prevNode != null) {
                    prevNode.next = pointerTwo;
                }
                prevNode = pointerTwo;
                pointerTwo = pointerTwo.next;
                prevNode.next = pointerOne;
            }
        }
        if (pointerOne == null) {
            prevNode.next = pointerTwo;
        }
        return (headOne.value < headTwo.value) ? pointerOne : pointerTwo;
    }
}
