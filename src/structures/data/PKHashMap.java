package structures.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PKHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
//        HashMap<Integer, String> map = new HashMap<>(17, 0.5f);    // initialCapacity, loadFactor
        map.put(31, "David");
        map.put(11, "Neha");
        map.put(22, "Shubham");
        System.out.println(map);

        String student = map.get(31);
        System.out.println(student);    // David

        String s = map.get(69);
        System.out.println(s);  // null

        System.out.println(map.containsKey(22)); // true
        System.out.println(map.containsValue("Neha")); // true

        for (int i : map.keySet()) {
            System.out.println(map.get(i));
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        for (Map.Entry<Integer, String> entry : entries) {
            entry.setValue(entry.getValue().toUpperCase());
        }
        System.out.println(map);

//        map.remove(31); // it will remove David
        boolean res = map.remove(31, "Nita");
        System.out.println("Removed ? : " + res);
        System.out.println(map);
    }
}
