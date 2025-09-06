package structures.data;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PKCopyOnWriteArrayList {
    public static void main(String[] args) {
//        List<String> shoppingList = new ArrayList<>();
//        ArrayList gives ConcurrentModificationException if we change list while reading
//        But CopyOnWriteArrayList doesn't throw error
        CopyOnWriteArrayList<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
        System.out.println("Initial shopping list: " + shoppingList);

        for (String item : shoppingList) {
            System.out.println(item);
            // Modifying the list while reading
            if (item.equals("Eggs")) {
                shoppingList.add("Butter");
                System.out.println("Added Butter while reading the list");
            }
        }
        // Reference will be updated to new list after for loop ends
        // So "Butter" won't be printed as it is added on new copy of list whose reference is added only after loop ends.
        System.out.println("Updated shopping list: " + shoppingList);


//        List<String> sharedList = new ArrayList<>();
//        ArrayList gives ConcurrentModificationException if we change list while reading
//        But CopyOnWriteArrayList doesn't throw error
        List<String> sharedList = new CopyOnWriteArrayList<>();
        sharedList.add("Item1");
        sharedList.add("Item2");
        sharedList.add("Item3");
        Thread readerThread = new Thread(() -> {
            try {
                while (true) {
                    // Iterate through list -- infinite loop
                    for (String item : sharedList) {
                        System.out.println("Reading item: " + item);
                        Thread.sleep(100);  // small delay to simulate work
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception in reader thread: " + e);
            }
        });
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(500); // delay to allow reading to start first
                sharedList.add(("Item4"));
                System.out.println("Added Item4 to the list.");

                Thread.sleep(500);
                sharedList.remove("Item1");
                System.out.println("Removed Item1 from list.");
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        });
        readerThread.start();
        writerThread.start();
    }
}
