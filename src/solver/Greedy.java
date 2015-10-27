package solver;

import component.Bag;
import component.Item;

import java.util.Collections;
import java.util.List;

/**
 * Created by melkir on 27/10/2015.
 */
public class Greedy extends KnapsackSolver {
    String type;

    public Greedy(List<Item> items, int capacity) {
        super(items, capacity);
        type = "default";
    }

    public Greedy(List<Item> items, int capacity, String type) {
        super(items, capacity);
        this.type = type;
    }

    private void sort(String type) {
        switch (type) {
            case "weight":
                Collections.sort(items, Item.byWeight());
                break;
            case "value":
                Collections.sort(items, Item.byValue());
                break;
            default:
                Collections.sort(items, Item.byRatio());
                break;
        }
    }

    @Override
    public Bag solve() {
        sort(type);
        int i, capUsed = 0, value = 0;
        for (i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (capUsed + item.getWeight() > capacity) break;
            capUsed += item.getWeight();
            value += item.getValue();
        }
        return new Bag(capUsed, value, items.subList(0, i));
    }

}
