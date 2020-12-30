package dsalgo.linkedList.CircularSingleLinkedList;


public class CircularSingleLinkedListMain{
    public static void main(String[] args) {
        // creating a circular single linked list object
        CircularSingleLinkedList csll = new CircularSingleLinkedList();
        
        // adding value to the linked list(at the beginning)
        System.out.println("Adding at the beginning");
        csll.push(100);
        csll.push(200);
        csll.push(300);
        csll.push(400);

        // traversing the linked list
        csll.printLinkedList();

        //searching a node by index
        CircularSingleLinkedList.Node node = csll.searchByIndex(1);
        System.out.println(node.data);

        //insert in between
        System.out.println("Inserting in between");
        csll.pushAfter(2, "XXX");
        csll.printLinkedList();

        // insert a node at the start
        System.out.println("insert at the start");
        csll.insertAtTheStart("A");
        csll.insertAtTheStart("B");
        csll.insertAtTheStart("X");

        //delete a node
        System.out.println("Deleting a node from given index...");
        csll.deleteNode(3);
        csll.printLinkedList();

        //
    }
}