package dsalgo.linkedList.CircularSingleLinkedList;

public class CircularSingleLinkedList{
    Node head;
    Node tail;
    int size;

    class Node {
        Node next;
        Object data;
        
        Node(Object data){
            this.data = data;
            this.next = null;
        }
    }

    // add a node at the beginning
    public void insertAtTheStart(Object data){
        Node newNode = new Node(data);
        if ( head == null){
            head = newNode;
            tail = newNode;
            tail.next = newNode;
            size++;
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        head = newNode;
        size++;
    }
    
    // insert a node inbetween 
    public void pushAfter(int index, Object data){
        Node newNode = new Node(data);
        Node indexedNode = searchByIndex(index);
        if(getSize() == 0){
            System.out.println(" The linked list is empty");
            return;
        }
        else if ( tail == indexedNode && indexedNode == head){
            head.next = newNode;
            tail = newNode;
            return;
        }
        newNode.next = indexedNode.next;
        indexedNode.next = newNode;
        if ( indexedNode == tail){
            tail = newNode;
        }
    }

    // search a node (given Index)
    public Node searchByIndex(int index){
        int indexCount= 0;
        if ( head == null ){
            System.out.println("The linked list is empty");
            return null;
        }
        Node tempNode = head;
        do{
            if ( indexCount == index){
                System.out.println("found at index->"+indexCount);
                return tempNode;
            }
            indexCount++;
            tempNode = tempNode.next;
        }
        while (tempNode != head);

        return null;
    }


    // delete a node (given index)
    public boolean deleteNode(int index){
        if (head == null){
            System.out.println("The linked list is empty");
            return false;
        }
        else if (index == 0){
            head = head.next;
            tail = head;
            size--;
            return true;
        }
        Node nextNode = head.next;
        Node prevNode = head;
        int indexCount = 1;

        while( nextNode != head){
            if (indexCount == index){
                if (nextNode == tail){
                    prevNode.next = head;
                    tail = prevNode;
                    size--;
                    return true;
                }
                prevNode.next = nextNode.next;
                size--;
                return true;
            }
            nextNode = nextNode.next;
            prevNode = prevNode.next;
            indexCount++;
        }
        return false;
    }

    // add node at the end
    public void push(Object data){
        Node newNode = new Node(data);
        if( head == null){
            head = newNode;
            tail = newNode;
            head.next = newNode;
            size++;
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        tail = newNode;
        size++;
    } 

    // traverse the linked list
    public void printLinkedList(){
        if ( head == null){
            System.out.println("The linked list is empty");
            return;
        }
        Node tempNode = head;
        do{
            System.out.println(tempNode.data+ " ");
            tempNode = tempNode.next;
        }
        while(tempNode != head);
    }

    // delete entire linked list
    public boolean deleteLinkedList(){
        if (head == null){
            tail = null;
            System.out.println("No nodes in linked list...");
            return false;
        }
        head = null;
        tail =  null;
        size = 0;
        return true;
    }

    public int getSize(){
        return size;
    }
    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }
}