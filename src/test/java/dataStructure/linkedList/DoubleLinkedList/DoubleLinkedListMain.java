package dataStructure.linkedList.DoubleLinkedList;

public class DoubleLinkedListMain{
    public static void main(String[] args){
        DoubleLinkedList dll = new DoubleLinkedList();
        
        // inserting add the beginning
        System.out.println("\n\n\ninserting at the beginning");
        dll.push(100);
        dll.push(200);
        dll.push(300);
        dll.push(400);

        // printing clockwise 
        System.out.println("\n\n\ninserting printing clockwise");
        dll.printLinkedList();
        
        // printing anti-clockwise
        System.out.println("\n\n\nprinting anticlockwise");
        dll.printLinkedListReverse();

        //Searching a node
        System.out.println("\n\n\nSearching a node by value...");
        dll.searchNode(200);

        System.out.println("\n\n\nSearching a node by given index");
        dll.searchNodeByIndex(2);

    }
}