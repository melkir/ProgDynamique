package component;

import java.util.Comparator;

/**
 * Created by melkir on 27/10/2015.
 */
public class Item {

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {

        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getRatio() {
        return value / weight;
    }

    public static Comparator<Item> byRatio() {
        return (o1, o2) -> Double.compare(o2.getRatio(), o1.getRatio());
    }

    public static Comparator<Item> byValue() {
        return (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue());
    }

    public static Comparator<Item> byWeight() {
        return (o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight());
    }

    private int value, weight;

    @Override
    public String toString() {
        return ""+ value + ' ' + weight;
    }
}
