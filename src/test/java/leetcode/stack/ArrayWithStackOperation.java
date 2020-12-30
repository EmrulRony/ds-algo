package leetcode.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ArrayWithStackOperation {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new LinkedList<>();
        int current = 0;
        int count = 1;
        while (current < target.length){
            if (count == target[current]){
                list.add("Push");
            } else {
                list.add("Push");
                list.add("Pop");
                count++;
                continue;
            }
            current++;
            count++;
        }
        return list;
    }
}
