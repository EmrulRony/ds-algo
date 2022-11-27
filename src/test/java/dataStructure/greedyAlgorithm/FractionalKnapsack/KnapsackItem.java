package dataStructure.greedyAlgorithm.FractionalKnapsack;

public class KnapsackItem {
    String itemName;
    Integer weight;
    Integer value;
    Double ratio;

    public KnapsackItem(String itemName, Integer weight, Integer value) {
        this.itemName = itemName;
        this.weight = weight;
        this.value = value;
        ratio = (double) value/weight;
    }
}
