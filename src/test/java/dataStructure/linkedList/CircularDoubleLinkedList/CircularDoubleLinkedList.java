package dataStructure.linkedList.CircularDoubleLinkedList;

public class CircularDoubleLinkedList{
    Node head;
    Node tail;
    int size;

    class Node{
        Node nextNode;
        Node prevNode;
        int size;
        Object data;

        public Node(Object data){
            this.data = data;
            nextNode = null;
            prevNode = null;
        }
    }

    // Inserting a node at the end 
    public boolean push(Object data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
            newNode.prevNode = newNode;
            newNode.nextNode = newNode;
            size++;
            return true;
        }
        tail.nextNode = newNode;
        newNode.nextNode = head;
        tail = newNode;
        size++;
        return true;
    }

    // Inserting a node at the start
    public boolean insertAtTheStart(Object data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            head.nextNode = newNode;
            tail.nextNode = newNode;
            size++;
            return false;
        }
        newNode.nextNode = head;
        tail.nextNode = newNode;
        head = newNode;
        size++;
        return true;
    }
    
    // Traversing the linkedlist
    public void printList(){
        if (size == 0){
            System.out.println("The linkedlist is empty");
            return;
        }

        Node tempNode = head;
        do{
            System.out.print(tempNode.data+" ");
            tempNode = tempNode.nextNode;
        } while(tempNode != head);
    }

    // 
}