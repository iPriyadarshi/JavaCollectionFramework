package structures.data;

import java.lang.ref.WeakReference;

public class GarbageCollector {
    public static void main(String[] args) {
        WeakReference<Phone> phoneWeakReference = new WeakReference<>(new Phone("Apple", "16 Pro Max"));
        System.out.println(phoneWeakReference.get());
        System.gc();    // Runs the garbage collector in the Java Virtual Machine.
        try {
            Thread.sleep(5000);
        } catch (Exception ignored) {

        }
        System.out.println(phoneWeakReference.get());   // null

    }
}


class Phone {
    String brand;
    String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + '}';
    }
}