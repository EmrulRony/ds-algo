package dsalgo.Queue.ArrayImplementation.LinearArrayImplementation;

public class LinearArrayQueueMain{
    public static void main(String[] args) {
        LinearArrayQueue queue = new LinearArrayQueue(5);

        System.out.println("Starting enqueue operation...\n");

        queue.enqueue(10);
        System.out.println("Head: "+ queue.getHead());
        System.out.println("Tail: "+ queue.getTail());
        queue.enqueue(20);
        System.out.println("Head: "+ queue.getHead());
        System.out.println("Tail: "+ queue.getTail());
        queue.enqueue(30);
        System.out.println("Head: "+ queue.getHead());
        System.out.println("Tail: "+ queue.getTail());
        queue.enqueue(40);
        System.out.println("Head: "+ queue.getHead());
        System.out.println("Tail: "+ queue.getTail());
        queue.enqueue(50);

        System.out.println("is stack full? "+queue.isFull());

        System.out.println("\nStarting dequeue operation");

        System.out.println("Head: "+ queue.getHead());
        System.out.println("Tail: "+ queue.getTail());
        queue.dequeue();
        System.out.println("Head: "+ queue.getHead());
        System.out.println("Tail: "+ queue.getTail());
        queue.dequeue();
        System.out.println("Head: "+ queue.getHead());
        System.out.println("Tail: "+ queue.getTail());
        queue.dequeue();
        System.out.println("Head: "+ queue.getHead());
        System.out.println("Tail: "+ queue.getTail());
        queue.dequeue();
        System.out.println("Head: "+ queue.getHead());
        System.out.println("Tail: "+ queue.getTail());
        queue.dequeue();

        System.out.println("is stack empty? "+queue.isEmpty());

        queue.dequeue();
    }
}