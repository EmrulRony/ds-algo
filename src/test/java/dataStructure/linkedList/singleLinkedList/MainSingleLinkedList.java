package dataStructure.linkedList.singleLinkedList;

public class MainSingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();

        // Insert into the linked list
        System.out.println("\n\n\nInserting at the beginning.....");
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.printLinkedList();
    }
}
