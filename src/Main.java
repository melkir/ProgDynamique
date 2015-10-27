import component.Bag;
import component.Item;
import solver.DynamicProgramming;
import solver.KnapsackSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int nbItem;
    private static int capacity;
    private static List<Item> items;

    private static void init(File file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert scanner != null;

        nbItem = scanner.nextInt();
        capacity = scanner.nextInt();
        items = new LinkedList<>();
        for (int i = 0; i < nbItem; i++) {
            Item item = new Item();
            item.setValue(scanner.nextInt());
            item.setWeight(scanner.nextInt());
            items.add(item);
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("data/ks_4_0");
        init(file);
        System.out.println("Import file : " + nbItem + " items, max capacity " + capacity + " kg");
//        KnapsackSolver solver = new Greedy(items, capacity);
        KnapsackSolver solver = new DynamicProgramming(items, capacity);
        System.out.println("Start processing...");
        Bag bag = solver.solve();
        System.out.println("End processing !");
        System.out.println(bag.toString());
    }
}
