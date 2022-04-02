package algoexpert.array.moveElementToEnd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Program {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int leftPointer = 0;
        int rightPointer = array.size() - 1;
        while (leftPointer < rightPointer) {
            int numberToBeMoved = array.get(leftPointer);
            int numberToBeReplaced = array.get(rightPointer);
            if (numberToBeMoved == toMove) {
                if (numberToBeMoved != numberToBeReplaced) {
                    array.set(leftPointer, numberToBeReplaced);
                    array.set(rightPointer, numberToBeMoved);
                    leftPointer++;
                }
                rightPointer--;
            } else {
                leftPointer ++;
            }
        }
        return array;
    }


    @Test
    public void TestCase1() {
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        int toMove = 2;
        List<Integer> expectedStart = new ArrayList<Integer>(Arrays.asList(1, 3, 4));
        List<Integer> expectedEnd = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2));
        List<Integer> output = Program.moveElementToEnd(array, toMove);
        List<Integer> outputStart = output.subList(0, 3);
        outputStart.sort(Comparator.naturalOrder());
        List<Integer> outputEnd = output.subList(3, output.size());
        assertEquals(outputStart, expectedStart);
        assertEquals(outputEnd, expectedEnd);
    }
}
