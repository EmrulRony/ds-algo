package dsalgo.linkedList.singleLinkedList;

import org.junit.Test;

public class SingleLinkedList {
    Node head, tail;
    int size;

    static class Node {
        Node next;
        Object data;

        Node(Object data) {
            this.data = data;
        }
    }


    // insert at the end
    public void add(Object data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    // search a node by given value
    public boolean contains(Object value) {
        if (head != null) {
            if (head.data == value) return true;
            else if (tail.data == value) return true;
            else {
                Node tempNode = head;
                while (tempNode != null) {
                    if (tempNode.data == value) {
                        return true;
                    }
                    tempNode = tempNode.next;
                }
            }
        }
        return false;
    }

    // insert at the beginning
    public void addFirst(Object data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            size++;
            return;
        } else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    // print list
    public void printLinkedList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }


    @Test
    public void insertTest() {
        SingleLinkedList linkedList = new SingleLinkedList();
        // Insert into the linked list
        System.out.println("Inserting at the end.....");
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.printLinkedList();

        // Insert at the beginning
        System.out.println("\n\n\nInserting at the end...");
        linkedList.addFirst("X");
        linkedList.printLinkedList();

        // search  a value in the linked list
        System.out.println("\n\n\nSearching a node by given value....");
        boolean isFound = linkedList.contains("Y");
        System.out.println("Is found ---> "+isFound);
    }
}
