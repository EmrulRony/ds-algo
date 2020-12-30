package dsalgo.Queue.ArrayImplementation.CircularArrayImplementation;

public class CircularArrayQueueMain{
    public static void main(String[] args) {
        CircularArrayQueue queue = new CircularArrayQueue(6);
        System.out.println("\nperforming enqueue operations...");
        queue.enqueue(10);
        System.out.println("Head--> "+queue.getHead());
        System.out.println("Tail--> "+queue.getTail());
        queue.enqueue(20);
        System.out.println("Head--> "+queue.getHead());
        System.out.println("Tail--> "+queue.getTail());
        queue.enqueue(30);
        System.out.println("Head--> "+queue.getHead());
        System.out.println("Tail--> "+queue.getTail());
        queue.enqueue(40);
        System.out.println("Head--> "+queue.getHead());
        System.out.println("Tail--> "+queue.getTail());
        queue.enqueue(50);
        System.out.println("Head--> "+queue.getHead());
        System.out.println("Tail--> "+queue.getTail());
        queue.enqueue(60);
        System.out.println("Head--> "+queue.getHead());
        System.out.println("Tail--> "+queue.getTail());

        System.out.println(queue.enqueue(100));

        System.out.println("\nperforming dequeue operations...");
        queue.dequeue();
        System.out.println("Head--> "+queue.getHead());
        System.out.println("Tail--> "+queue.getTail());
        queue.dequeue();
        System.out.println("Head--> "+queue.getHead());
        System.out.println("Tail--> "+queue.getTail());

        System.out.println("\nagain performing enqueue operations...");
        queue.enqueue(100);
        System.out.println("Head--> "+queue.getHead());
        System.out.println("Tail--> "+queue.getTail());
        queue.enqueue(200);
        System.out.println("Head--> "+queue.getHead());
        System.out.println("Tail--> "+queue.getTail());

        queue.enqueue(200);


    }
}