package dataStructure.tree.binary_tree;

public class BinaryTreeByArray {
    int[] arr;
    int lastIndexUsed;

    public BinaryTreeByArray(int size) {
        arr = new int[size + 1];
        lastIndexUsed = 0;
    }

    private boolean isFull() {
        return lastIndexUsed == arr.length - 1;
    }

    public void insert(int val) {
        if (!isFull()) {
            arr[lastIndexUsed + 1] = val;
            lastIndexUsed++;
        }
    }

    public void levelOrderTraversal() {
        for (int i = 1; i <= lastIndexUsed; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }

    public void preOrderTraversal() {
        if (arr.length != 0) {
            preOrderTraversal(1);
        }
    }

    private void preOrderTraversal(int index) {
        if (index <= lastIndexUsed) {
            System.out.print(arr[index] + " ");
            preOrderTraversal(2 * index);
            preOrderTraversal((2 * index) + 1);
        }
    }

    public static void main(String[] args) {
        BinaryTreeByArray bt = new BinaryTreeByArray(10);
        for (int i = 1; i <= 10; i++) {
            bt.insert(10 * i);
        }

        System.out.println("Level order....");
        bt.levelOrderTraversal();

        System.out.println("Preorder order....");
        bt.preOrderTraversal();

    }
}
