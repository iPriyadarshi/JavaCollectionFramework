package structures.data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PKLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(11,0.8f,true);
        // order of insertion maintained if accessOrder: false (default: false)
        // otherwise entries are ordered based on accessOrder. Most recently accessed entry is moved to end of linked list
//        HashMap<String, Integer> hashMap = new HashMap<>();       // no insertion order
        linkedHashMap.put("Orange", 10);
        linkedHashMap.put("Apple", 20);
        linkedHashMap.put("Guava", 12);

        linkedHashMap.get("Apple");
        System.out.println(linkedHashMap);

        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // creating linkedHashMap from hashMap
        HashMap<String,Integer> hashMap = new HashMap<>();
        LinkedHashMap linkedHashMap1 = new LinkedHashMap<>(hashMap);


    }
}
