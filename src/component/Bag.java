package component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by melkir on 27/10/2015.
 */
public class Bag {
    private final int capacity;
    private final int value;
    private List<Item> items = new LinkedList<>();

    public Bag(int capacity, int value, List<Item> items) {
        this.capacity = capacity;
        this.value = value;
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "The bag contain "
                + items.size() + " items, weighs " + capacity + " kg and has a value of " + value
                + "\nIt contains the item(s) " + items.toString();
    }

}
