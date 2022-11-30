package algoexpert.greedy.tandemBycycle;

import java.util.Arrays;

public class Program {

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int totalSpeed = 0;
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            totalSpeed += Math.max(redShirtSpeeds[i], fastest ? blueShirtSpeeds[blueShirtSpeeds.length - i - 1] : blueShirtSpeeds[i]);
        }
        return totalSpeed;
    }
}
