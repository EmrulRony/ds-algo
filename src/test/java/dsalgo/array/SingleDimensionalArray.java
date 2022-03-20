package dsalgo.array;

public class SingleDimensionalArray {
    int[] arr = null;

    // Construct Array
    SingleDimensionalArray(int size) {
        arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    // Inserting value into array
    void insertValue(int index, int value) {
        if (index > arr.length - 1) {
            System.out.println("The index doesn't exists");
            return;
        }
        arr[index] = value;
        System.out.println("Insertion successful!!");
    }

    // Traverse array
    void traverseArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Access a particular element in Array
    void findElement(int index) {
        if (index > arr.length) {
            System.out.println("The index doesn't exists");
        }
        System.out.println("The value in the given index: " + arr[index]);
    }

    // Search a value in the array
    void searchValue(int value) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                System.out.println("The value found at the index of " + i);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Value not found!!");
    }

    // Delete value from a given array (given cell)
    void deleteValue(int index) {
        if (index > arr.length) {
            System.out.println("Is is not there");
            return;
        }
        arr[index] = Integer.MIN_VALUE;
    }

    // Delete an entire array
    void deleteEntireArray() {
        if (arr != null) {
            arr = null;
            System.out.println("Delete Success!!");
        }
    }
}
