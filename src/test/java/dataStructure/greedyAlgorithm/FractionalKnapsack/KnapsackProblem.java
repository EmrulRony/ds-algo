package dataStructure.greedyAlgorithm.FractionalKnapsack;

import java.util.ArrayList;
import java.util.List;

public class KnapsackProblem {

    public double getMaxValue(List<KnapsackItem> knapsackItems, Integer capacity) {
        knapsackItems.sort((item1, item2) -> Double.compare(item2.ratio, item1.ratio));
        double value = 0.0;
        Integer weight = 0;
        for (KnapsackItem item : knapsackItems) {
            if (weight + item.weight <= capacity) {
                value += (double) item.value;
                weight += item.weight;
            } else {
                Integer usableWeight = capacity - weight;
                value += item.ratio * usableWeight;
                weight += usableWeight;
            }
            if (weight.equals(capacity)) {
                break;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        List<KnapsackItem> items = new ArrayList<>();
        items.add(new KnapsackItem("A1", 6, 6));
        items.add(new KnapsackItem("A2", 10, 2));
        items.add(new KnapsackItem("A3", 3, 1));
        items.add(new KnapsackItem("A4", 5, 8));
        items.add(new KnapsackItem("A5", 1, 3));
        items.add(new KnapsackItem("A6", 3, 5));

        KnapsackProblem knapsackProblem = new KnapsackProblem();
        double result = knapsackProblem.getMaxValue(items, 10);
        System.out.println(result);
    }
}
