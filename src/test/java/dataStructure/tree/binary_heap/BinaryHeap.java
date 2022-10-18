package dataStructure.tree.binary_heap;

public class BinaryHeap {
    private final int[] values;
    private int lastIndexUsed;

    public BinaryHeap(int size) {
        values = new int[size + 1];
        lastIndexUsed = 0;
    }

    public void insert(int value) {
        if (lastIndexUsed != values.length - 1) {
            values[lastIndexUsed + 1] = value;
            lastIndexUsed++;
            heapifyBottomToTop(lastIndexUsed);
        }
    }

    private void heapifyBottomToTop(int index) {
        int parentIndex = index / 2;
        if (parentIndex > 0 && values[index] < values[parentIndex]) {
            int temp = values[parentIndex];
            values[parentIndex] = values[index];
            values[index] = temp;
            heapifyBottomToTop(parentIndex);
        }
    }

    public int removeTop() {
        int topOfTheHeap = values[1];
        values[1] = values[lastIndexUsed];
        lastIndexUsed--;
        heapifyTopToBottom(1);
        return topOfTheHeap;
    }

    private void heapifyTopToBottom(int index) {
        int leftChild = 2 * index;
        int rightChild = (2 * index) + 1;
        if (lastIndexUsed >= leftChild) {
            if (leftChild == lastIndexUsed) { // only left child left, there is no right child
                swap(index, leftChild);
            } else { // both child available
                int smallestChild = Math.min(values[leftChild], values[rightChild]);
                int parent = values[index];
                if (smallestChild < parent) {
                    if (values[leftChild] < values[rightChild]) {
                        swap(leftChild, index);
                        heapifyTopToBottom(leftChild);
                    } else {
                        swap(rightChild, index);
                        heapifyTopToBottom(rightChild);
                    }
                }
            }
        }
    }

    private void swap(int parent, int child) {
        int temp = values[parent];
        values[parent] = values[child];
        values[child] = temp;
    }

    private void levelOrder() {
        for (int i = 1; i <= lastIndexUsed; i++) {
            System.out.print(values[i] + " ");
        }
    }

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(10);

        heap.insert(100);
        heap.insert(90);
        heap.insert(80);
        heap.insert(70);
        heap.insert(60);
        heap.insert(50);
        heap.insert(40);
        heap.insert(30);
        heap.insert(20);
        heap.insert(1);

        System.out.println("level order....");
        heap.levelOrder();

        System.out.println();
        System.out.println("Top "+ heap.removeTop());
        System.out.println("level order.....");
        heap.levelOrder();
    }


}
