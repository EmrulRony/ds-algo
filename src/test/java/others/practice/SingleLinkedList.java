package others.practice;

import org.junit.Test;

public class SingleLinkedList {
    private Node head, tail;
    private int size;

    static class Node {
        Node next;
        Object data;

        public Node(Object data) {
            this.data = data;
        }
    }

    public void add(Object object) {
        Node node = new Node(object);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public boolean contains(Object value) {
        if (head != null) {
            if (head.data == value || tail.data == value) {
                return true;
            } else {
                Node currentNode = head;
                while (currentNode != null) {
                    if (currentNode.data == value) return true;
                    currentNode = currentNode.next;
                }
            }
        }
        return false;
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }


    @Test
    public void test() {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        linkedList.print();
    }
}
