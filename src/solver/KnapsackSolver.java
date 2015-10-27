package solver;

import component.Bag;
import component.Item;

import java.util.List;

/**
 * Created by melkir on 27/10/2015.
 */
public abstract class KnapsackSolver {
    protected final List<Item> items;
    protected final int capacity;

    public KnapsackSolver(List<Item> items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }

    public abstract Bag solve();
}
