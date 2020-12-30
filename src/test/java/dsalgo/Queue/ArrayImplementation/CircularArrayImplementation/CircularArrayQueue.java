// the problem with linear array implemented queue is 
// data gets enqueued only at the end of tail and 
// data dequeued from head
// so once the queue is full we can't insert any value even if we dequeue
// so, the solution is circular array implemented queue

package dsalgo.Queue.ArrayImplementation.CircularArrayImplementation;

public class CircularArrayQueue{
    int arr [];
    int head = -1;
    int tail = -1;
    int reverseInsert = -1;

    public CircularArrayQueue(int size){
        arr = new int[size];
    }

    public boolean enqueue(int data){ 
        if (!isFull()){
            if (tail == -1){
                arr[++head] = data;
                tail++;
                return true;
            }
            else if(head != 0 && tail == arr.length-1){
                if (arr[++reverseInsert] == 0){
                    System.out.println("array is full");
                    return false;
                }
                arr[reverseInsert] = data;
                tail = reverseInsert;
                return true;
            }
            arr[++tail] = data;
            return true;
        }
        else {
            System.out.println("The queue is already full");
            return false;
        }
    }

    public int dequeue(){
        if (isEmpty()){
            System.out.println("the queue is empty");
            return -1;
        }
        int returnData = arr[head];
        head++;
        return returnData;
    }

    public int getHead(){
        if (!isEmpty()){
            System.out.println("head at index--> "+head);
            return arr[head];
        }
        System.out.println("the queue is empty");
        return -1;
    }

    public int getTail(){
        if (!isEmpty()){
            System.out.println("tail at index--> "+tail);
            return arr[tail];
        }
        System.out.println("head the queue is empty");
        return -1;
    }

    public boolean isFull(){
        return (head == 0 && tail == arr.length-1) || (tail+1 == head &&  arr[arr.length-1] != 0)? true : false;
    }

    public boolean isEmpty(){
        return ((head == -1 && tail == -1) || head == arr.length) ?  true : false;
    }
}