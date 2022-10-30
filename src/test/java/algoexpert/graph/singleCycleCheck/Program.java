package algoexpert.graph.singleCycleCheck;

public class Program {
    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        int numOfElementVisited = 0;
        int currentIndex = 0;
        while (numOfElementVisited < array.length) {
            if (numOfElementVisited > 0 && currentIndex == 0) {
                return false;
            }
            numOfElementVisited++;
            currentIndex = getCurrentIndex(currentIndex, array);
        }
        return currentIndex == 0;
    }

    private static int getCurrentIndex(int currentIndex, int[] array) {
        int nextJump = array[currentIndex];
        int nextIndex = (currentIndex + nextJump) % array.length; // (2+6) % 6 = 2 (next pointer at idx 2)
        return nextIndex >= 0 ? nextIndex : nextIndex + array.length; // -4 + 6 = 2 (next pointer at idx 2)
    }
}

