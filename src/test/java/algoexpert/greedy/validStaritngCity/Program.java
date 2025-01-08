package algoexpert.greedy.validStaritngCity;

public class Program {

    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        // Write your code here.
        int length = distances.length;
        int mileageLeft = 0;
        int minIdx = 0;
        int minFuelLeft = 0;
        for (int idx = 1; idx < length; idx++) {
            mileageLeft += (fuel[idx - 1] * mpg) - distances[idx - 1];
            if (mileageLeft < minFuelLeft) {
                mileageLeft = minFuelLeft;
                minIdx = idx;
            }
        }
        return minIdx;
    }
}

