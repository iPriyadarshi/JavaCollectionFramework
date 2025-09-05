package structures.data;

import java.util.Arrays;
import java.util.LinkedList;

/*
class Node {
    public int value;
    public Node next;
}
*/
public class PKLinkedList {
    public static void main(String[] args) {
        /*
        Manual creation of ll
        Node node1 = new Node();
        Node node2 = new Node();
        node2.value = 2;
        node1.value = 1;
        node1.next = node2;
        node2.next=null;
        */

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        int a = linkedList.get(2);  // O(n)
        System.out.println(a);

        linkedList.addLast(4);  // O(1) as it is doubly LL
        linkedList.addFirst(0); // O(1)
        int first = linkedList.getFirst();
        System.out.println(first);
        int last = linkedList.getLast();
        System.out.println(last);
        System.out.println(linkedList);
        linkedList.removeIf(x -> x % 2 == 0);    // even ele removed
        System.out.println(linkedList);

        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Dog", "Elephant"));
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Lion", "Dog"));
        animals.removeAll(animalsToRemove);
        System.out.println(animals);

    }
}
