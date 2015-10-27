package solver;

import component.Bag;
import component.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melkir on 27/10/2015.
 */
public class DynamicProgramming extends KnapsackSolver {
    private int[][] table;

    public DynamicProgramming(List<Item> items, int capacity) {
        super(items, capacity);
    }

    @Override
    public Bag solve() {
        table = new int[capacity + 1][items.size()];
        for (int j = 0; j < capacity + 1; j++)
            for (int i = 0; i < items.size(); i++)
                table[j][i] = -1;
        getCell(capacity, items.size() - 1);
        return bestBag();
    }

    private Bag bestBag() {
        List<Item> res = new ArrayList<>();
        int value = 0, weight = 0;
        int i = items.size() - 1, j = capacity;
        // Traces back table
        while (i > 0) {
            Item item = items.get(i);
            int without = table[j][(i - 1)];
            if (table[j][i] != without) {
                res.add(item);
                value += item.getValue();
                weight += item.getWeight();
                j -= item.getWeight();
            }
            i--;
        }
        return new Bag(weight, value, res);
    }

    // Uses recursion with memorization
    private int getCell(int j, int i) {
        if (i < 0 || j < 0) return 0;
        Item item = items.get(i);
        int with, without, cell = table[j][i];
        // If not memorized
        if (cell == -1) {
            if (item.getWeight() > j) with = -1;
            else with = item.getValue() + getCell(j - item.getWeight(), i - 1);
            without = getCell(j, i - 1);
            cell = Math.max(with, without);
            table[j][i] = cell; // Memorize
        }
        return cell;
    }

    /*
    public void printTable() {
        for (int j = 0; j < capacity + 1; j++) {
            System.out.println();
            for (int i = 0; i < items.size(); i++) System.out.print(table[j][i] + "\t");
        }
    }
    */
}
