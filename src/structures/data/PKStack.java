package structures.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class PKStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        Integer removedElement = stack.pop();
        System.out.println(stack);
        Integer top = stack.peek();
        System.out.println("Element at top: " + top);
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        System.out.println("Size of stack: " + stack.size());

        int index_3 = stack.search(3);    // returns index from top // 1-based indexing
        System.out.println("Index of 3 from top: " + index_3);
        System.out.println();

        // LinkedList class can also be used to implement stack data structure
        LinkedList<Integer> st = new LinkedList<>();
        st.addLast(1);  // push
        st.addLast(2);
        st.addLast(3);
        st.getLast();   // peek
        st.removeLast();    // pop
        System.out.println(st.size());
        System.out.println(st.isEmpty());

        // ArrayList as stack
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);   // push
        arrayList.add(2);
        arrayList.add(3);
        arrayList.get(arrayList.size() - 1);  // peek
        arrayList.remove(arrayList.size() - 1);   // pop

    }
}
