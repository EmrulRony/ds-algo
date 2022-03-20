package dsalgo.linkedList.CircularDoubleLinkedList;


public class CircularDoubleLinkedListMain {
    public static void main(String[] args) {
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        System.out.println("\n\nInserting value at end");
        cdll.push("A");
        cdll.push("B");
        cdll.push("C");
        cdll.push("D");

        // printing values of linked list
        System.out.println("Printing the list");
        cdll.printList();

        // inserting value at the start
        System.out.println("\n\n\ninserting value at the start...");
        cdll.insertAtTheStart("X");

        // printing values of linked list
        System.out.println("Printing the list");
        cdll.printList();
    }
}