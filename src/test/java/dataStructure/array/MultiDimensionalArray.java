package dataStructure.array;

public class MultiDimensionalArray {
    int rowNum;
    int colNum;
    int arr[][] = null;

    // Construction of the array
    MultiDimensionalArray(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        arr = new int[rowNum][colNum];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    // Insertion of values into array
    void insertValueInArray(int row, int col, int val) {
        if (arr[row][col] != Integer.MIN_VALUE) {
            System.out.println("Value is already assigned for this cell");
            return;
        }
        arr[row][col] = val;
        System.out.println("Insertion Success!!");
    }

    // Traverse through the array
    void printAllTheElements() {
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // find a single value by given index
    void findASingleValue(int row, int col) {
        if (row > 2 | col > 2) {
            System.out.println("Row/Col is invalid");
        }
        System.out.println("The value in the given cell is " + arr[row][col]);
    }

    // search a value (given value)
    void searchValue(int value) {
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (arr[i][j] == value) {
                    System.out.println("The value found in row " + i + " Column " + j);
                    return;
                }
            }
        }
        System.out.println("The value is not found");
    }

    // delete a value from array (given index)
    void deleteValue(int row, int col) {
        if (row > rowNum - 1 | col > colNum - 1) {
            System.out.println("Row/Col is invalid");
        }
        arr[row][col] = Integer.MIN_VALUE;
    }

    // delete the entire array
    void deleteEntireArray() {
        arr = null;
    }
}
