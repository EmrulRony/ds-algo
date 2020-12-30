package dsalgo.linkedList.DoubleLinkedList;

public class DoubleLinkedList{
    Node head;
    Node tail;
    int size;
    
    class Node{
        Object data;
        Node next;
        Node prev;

        Node(Object data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // insert at the beginning
    public boolean insertAtTheStart(Object data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
            size++;
            return true;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        size++;
        return false;
    }

    // insert a node at the end
    public boolean push(Object data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
            size++;
            return true;
        }
        head.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
        return true;
    }

    //insert a node in-between
    public boolean insertInBetween(int index, Object data){
        Node newNode = new Node(data);
        if (head == null){
            return false;
        }
        int indexCount = 0;
        Node tempNode = head;
        while(head != null){
            if (indexCount == index){
                newNode.prev = tempNode;
                newNode.next = tempNode.next.next;
                tempNode.next = newNode;
                size++;
                return true;
            }
            tempNode = tempNode.next;
            indexCount++;
        }
        return false;
    }

    // traverse linked list (from head to tail)
    public void printLinkedList(){
        if(head == null){
            System.out.println("The linked list is empty");
            return;
        }
        Node tempNode = head;
        while(tempNode != null){
            System.out.println(tempNode.data + " ");
            tempNode = tempNode.next;
        }
    }

    // traverse linked list (from tail to head)
    public void printLinkedListReverse(){
        if(head == null){
            System.out.println("The linked list is empty");
            return;
        }
        Node tempNode = tail;
        while( tempNode != null){
            System.out.println(tempNode.data + " ");
            tempNode = tempNode.prev;
        }
    }
    
    // search a node in the linked list (given index)
    public Node searchNodeByIndex(int index){
        if (head == null){
            System.out.println("The linked list is empty!!");
            return null;
        }
        int indexCount = 0;
        Node tempNode = head;
        while(tempNode !=null){
            if (index == indexCount){
                System.out.println("The node found at index "+index);
                return tempNode;
            }
            tempNode = tempNode.next;
            indexCount++;
        }
        System.out.println("node not found!");
        return null;
    }
    
    // search a node in the linked list (given value)
    public Node searchNode(int value){
        if (head == null){
            System.out.println("The linked list is empty!!");
            return null;
        }
        int indexCount = 0;
        Node tempNode = head;
        while(tempNode !=null){
            if (tempNode.data.equals(value)){
                System.out.println("The node found at index -> "+indexCount);
                return tempNode;
            }
            tempNode = tempNode.next;
            indexCount++;
        }
        System.out.println("Node not found!!");
        return null;
    }

    // delete a node from the linked list
    public boolean deleteNode(int index){
        if (head == null){
            tail = null;
            return false;
        }
        int indexCount = 0;
        Node tempNode = head;
        while (tempNode != null){
            if (index == 0){
                head = tempNode.next;
                head.prev = null;
                size--;
                return true;
            }
            else if (tempNode == tail){
                tail = tempNode.prev;
                tail.next= null;
                size--;
                return true;
            }
            else if (index == indexCount){
                tempNode.prev.next = tempNode.next;
                size--;
                return true;
            }
            tempNode = tempNode.next;
            index++;
        }
        return false;
    }
}