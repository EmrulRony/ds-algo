package algoexpert.linkedList.addTwoNumbers;

public class Program {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        LinkedList tempNode = new LinkedList(0);
        LinkedList currentNode = tempNode;
        int carry = 0;
        while (linkedListOne != null || linkedListTwo != null || carry != 0) {
            int valueOne = linkedListOne != null ? linkedListOne.value : 0;
            int valueTwo = linkedListTwo != null ? linkedListTwo.value : 0;
            int sum = valueOne + valueTwo + carry;
            int newValue = sum % 10;
            LinkedList newNode = new LinkedList(newValue);
            currentNode.next = newNode;
            currentNode = newNode;
            carry = sum / 10;
            linkedListOne = linkedListOne != null ? linkedListOne.next : null;
            linkedListTwo = linkedListTwo != null ? linkedListTwo.next : null;
        }
            return tempNode.next;
    }
}