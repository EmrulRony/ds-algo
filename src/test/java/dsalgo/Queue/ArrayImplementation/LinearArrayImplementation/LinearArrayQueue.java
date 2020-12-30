package dsalgo.Queue.ArrayImplementation.LinearArrayImplementation;

public class LinearArrayQueue{
    int head;
    int tail;
    int arr[];
    
    public LinearArrayQueue(int size){
        arr = new int[size];
        head = -1;
        tail = -1;
    }

    public boolean enqueue(int data){
        if (isFull()){
            System.out.println("The queue is full, unable to perform enqueue!!");
            return false;
        }
        else if (tail == -1){
            arr[++head] = data;
            tail++;
            return true;
        }
        arr[++tail] = data;
        return true;
    }

    public int dequeue(){
        if (tail == -1 || head == arr.length){
            System.out.println("the queue is empty");
            return -1;
        }
        int headData = arr[head];
        head++;
        return headData;
    }

    public boolean isEmpty(){
        return tail == -1 || head == arr.length ? true : false;
    }

    public boolean isFull(){
        return tail == arr.length-1 ? true : false;
    }

    public int getHead(){
        if (tail == -1){
            System.out.println("The queue is empty");
            return -1;
        }
        return arr[head];
    }

    public int getTail(){
        if (tail == -1){
            System.out.println("The queue is empty, unable perform deque!");
            return -1;
        }
        return arr[tail]; 
    }
}