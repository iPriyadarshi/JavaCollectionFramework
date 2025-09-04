package structures.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PKArrayList {
    public static void main(String[] args) {
        // Creation

        //  List<dataType> name = new ArrayList<>(initialCapacity);
        //  ArrayList<dataType> name = new ArrayList<>(initialCapacity);

        List<String> list1 = Arrays.asList("Monday", "Tuesday");
        System.out.println(list1.getClass().getName());     // java.util.Arrays$ArrayList
        // list1.add("Wednesday"); // it will throw error as .asList returns a fixed-size list backed by the specified array
        // it can only be modified (no new element addition possible)
        list1.set(1, "Thursday"); // correct // Monday, Thursday
        System.out.println(list1.get(1));   // Thursday

        String[] array = {"Apple", "Banana", "Orange"};
        List<String> list2 = Arrays.asList(array);
        System.out.println(list2.getClass().getName());     // java.util.Arrays$ArrayList

        List<String> list4 = new ArrayList<>(list2);
        list4.add("Mango");
        System.out.println(list4);

        List<Integer> list3 = List.of(1, 2, 3, 4);     // non-modifiable list.
        // list3.set(1,33);     // error as list cant be modified

        ArrayList<Integer> list = new ArrayList<>(100);
        System.out.println(list.getClass().getName());      // java.util.ArrayList

        // Adding elements
        list.add(1);    // 0
        list.add(10);   // 1
        list.add(15);   // 2
        list.add(12);   // 3

        // Fetching element by index
        System.out.println(list.get(3));    // 12

        // Getting size of list
        System.out.println(list.size());    // 4

        System.out.println();

        // Iterating over list
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            // 1 10 15 12
        }

        // Removing element by index
        list.remove(1); // removes ele at index 1
        // 1 15 12
        list.add(2, 23);
        // 1 15 23 12

        // Removing element by value
        list.remove(Integer.valueOf(15));
        // 1 23 12

        // Updating the value at any index
        list.set(2, 18);
        // 1 23 18
        System.out.println();
        for (int x : list) {
            System.out.println(x);
        }
        System.out.println();

        // Printing whole list
        System.out.println(list);
        System.out.println();

        // Checking if list contains a specific value
        System.out.println(list.contains(5));
        System.out.println(list.contains(15));

        System.out.println();

        // .addFirst and .addAll method
        List<Integer> list5 = new ArrayList<>();
        list5.add(1);
        list5.add(2);
        list5.add(3);
        list5.addFirst(0);
        System.out.println(list5);

        List<Integer> list6 = List.of(4, 5, 6, 7, 8);
        list5.addAll(list6);
        System.out.println(list5);

        // .toArray method
        Object[] arr2 = list5.toArray();
        Integer[] arr3 = list5.toArray(new Integer[0]);

        System.out.println();

        // Sorting an ArrayList
        System.out.println(list);
        Collections.sort(list);     // ascending order
        list.sort(null);    // this also sorts in asc order
        System.out.println(list);



/*
        // Checking size of internal array, elementData
        // To run this:
        // uncomment this code block
        // change main method to: public static void main(String[] args) throws Exception {}
        // add vm option in configuration:  --add-opens java.base/java.util=ALL-UNNAMED
        ArrayList<Integer> arr = new ArrayList<>(11);

        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(arr);
        System.out.println("Arraylist capacity: " + elementData.length);    // 11


        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        arr.add(11);
        arr.add(12);
        arr.add(13);

        elementData = (Object[]) field.get(arr);
        System.out.println("Arraylist capacity: " + elementData.length);    // 16 which is about 1.5 times 11(initial capacity)

        arr.remove(2);
        arr.remove(2);
        arr.remove(2);
        arr.remove(2);
        arr.remove(2);
        arr.remove(2);
        arr.remove(2);
        arr.remove(2);

        elementData = (Object[]) field.get(arr);
        System.out.println("Arraylist capacity: " + elementData.length);    // 16  // capacity not reduced by self

        arr.trimToSize();   // capacity can be reduced to size by this function

        elementData = (Object[]) field.get(arr);
        System.out.println("Arraylist capacity: " + elementData.length);    // 5
*/


    }
}
