package algoexpert.greedy.classPhoto;

import java.util.ArrayList;
import java.util.Collections;

public class Program {

    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // Write your code here.
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        if (redShirtHeights.get(0) > blueShirtHeights.get(0)) {
            return isTherePerfectPhoto(blueShirtHeights, redShirtHeights);
        } else {
            return isTherePerfectPhoto(redShirtHeights, blueShirtHeights);
        }
    }

    private boolean isTherePerfectPhoto(ArrayList<Integer> frontRow, ArrayList<Integer> backRow) {
        for (int i = 0; i < frontRow.size(); i++) {
            if (frontRow.get(i) >= backRow.get(i)) {
                return false;
            }
        }
        return true;
    }
}
