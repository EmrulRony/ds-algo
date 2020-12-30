package DS_QUEUE.LinkedListImplementation;

public class LinkedListStackImplementation{
    Node head;
    Node tail;
    int size;

    static class Node{
        Node link;
        Object data;
        Node(Object data){
            this.data = data;
            this.link = null;
        }
    }

    public boolean enqueue(Object data){
        Node newNode = new Node(data);
        if (size == 0){
            head = newNode;
            tail = newNode;
            size++;
            return true;
        }
        tail.link = newNode;
        tail = newNode;
        size++;
        return true;
    }

    public Object dequeue(){
        if (size == 0){
            System.out.println("The queue is empty!!");
            return -1;
        }
        Object returnData = head.data;
        head = head.link;
        size--;
        return returnData;
    }

    public Object getHead(){
        if (size == 0){
            System.out.println("The queue is empty!!");
            return -1;
        }
        return head.data;
    }

    public Object getTail(){
        if (size == 0){
            System.out.println("the queue is empty!!");
            return -1;
        }
        return tail.data;
    }

    public int getSize(){
        if (head == null){
            return 0;
        }
        return this.size;
    }

}