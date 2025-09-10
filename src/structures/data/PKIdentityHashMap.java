package structures.data;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Demonstrates the usage of IdentityHashMap, a Map implementation that uses
 * reference equality (==) instead of object equality (equals()) for key comparisons.
 * This class highlights the differences between IdentityHashMap and standard HashMap
 * in terms of how keys are handled and compared.
 */
public class PKIdentityHashMap {
    public static void main(String[] args) {
        // Create two distinct String objects with the same content
        String key1 = new String("key");
        String key2 = new String("key");

//        Map<String, Integer> map = new HashMap<>();
        // uses hashCode() and equals() method

        // Use IdentityHashMap, which compares keys using reference equality (==) instead of the equals() method used by standard HashMap
        Map<String, Integer> map = new IdentityHashMap<>();
        // uses identityHashCode() and ==

        // Print the identity hash code for key1 and key2
        // System.identityHashCode() returns a hash code based on the object's memory address
        // Since key1 and key2 are distinct objects, they have different identity hash codes
        System.out.println("identityHashCode for key1: " + System.identityHashCode(key1));
        System.out.println("identityHashCode for key2: " + System.identityHashCode(key2));

        // Print the hash code for key1 and key2
        // The hashCode() method is defined by the String class and is based on the content
        // Since key1 and key2 have the same content ("key"), they have the same hash code
        System.out.println("hashCode for key1: " + key1.hashCode());
        System.out.println("hashCode for key2: " + key2.hashCode());

        // Add key1 with value 1 to the map
        // In IdentityHashMap, key1 is stored as a unique key based on its reference
        map.put(key1, 1);    // key, 1

        // Add key2 with value 2 to the map
        // Since IdentityHashMap uses reference equality, key2 is treated as a different key even though key1 and key2 have the same content
        map.put(key2, 2);    // key, 2

        // Print the map contents
        // Output will show two entries because key1 and key2 are distinct objects
        // In contrast, a standard HashMap would treat key1 and key2 as the same key due to their equal content, resulting in only one entry
        System.out.println(map);
    }
}
