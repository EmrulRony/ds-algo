package algoexpert.greedy.minWaitingTime;

import java.util.Arrays;

public class Program {

    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int totalWaitingTime = 0;
        int lastWaitingTime = 0;
        for (int i = 1; i < queries.length; i++) {
            lastWaitingTime +=  queries[i-1];
            totalWaitingTime += lastWaitingTime;
        }
        return totalWaitingTime;
    }
}

