package DS_QUEUE.LinkedListImplementation;

public class LinkedListStackImplementationMain{
    public static void main(String[] args) {
        LinkedListStackImplementation stack = new LinkedListStackImplementation();
        
        // performing enqueue operations
        System.out.println("performing enqueue operations\n\n");
        stack.enqueue(10);
        System.out.println("head--> "+stack.getHead());
        System.out.println("tail--> "+stack.getTail());
        stack.enqueue(20);
        System.out.println("head--> "+stack.getHead());
        System.out.println("tail--> "+stack.getTail());
        stack.enqueue(30);
        System.out.println("head--> "+stack.getHead());
        System.out.println("tail--> "+stack.getTail());
        stack.enqueue(40);
        System.out.println("head--> "+stack.getHead());
        System.out.println("tail--> "+stack.getTail());
        stack.enqueue(50);
        System.out.println("head--> "+stack.getHead());
        System.out.println("tail--> "+stack.getTail());

        // performing dequeue operations
        System.out.println("\n\nperforming dequeue operations....");
        stack.dequeue();
        System.out.println("head--> "+stack.getHead());
        System.out.println("tail--> "+stack.getTail());
        stack.dequeue();
        System.out.println("head--> "+stack.getHead());
        System.out.println("tail--> "+stack.getTail());
        stack.dequeue();
        System.out.println("head--> "+stack.getHead());
        System.out.println("tail--> "+stack.getTail());
        stack.dequeue();
        System.out.println("head--> "+stack.getHead());
        System.out.println("tail--> "+stack.getTail());
        stack.dequeue();
        stack.dequeue();
    }
}