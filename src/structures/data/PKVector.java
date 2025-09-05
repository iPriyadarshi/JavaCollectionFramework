package structures.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PKVector {
    private static final Logger logger = Logger.getLogger(PKVector.class.getName());

    public static void main(String[] args) {
        // Constructor
        Vector<Integer> vector = new Vector<>(5, 3);
        System.out.println(vector.capacity());
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);
        System.out.println(vector.capacity());

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(12);
        Vector<Integer> vector1 = new Vector<>(linkedList);
        System.out.println(vector1);


        // ArrayList is not thread-safe but Vector is thread-safe
        ArrayList<Integer> list = new ArrayList<>();
//        Vector<Integer> list = new Vector<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Thread was interrupted during join", e);
            // Optionally restore the interrupt status:
            Thread.currentThread().interrupt();

        }
        System.out.println("Size of list: " + list.size());
        // Vector -> 2000 but less in case of ArrayList
    }
}
