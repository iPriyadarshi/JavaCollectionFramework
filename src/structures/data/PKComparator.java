package structures.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
//        return s1.length() - s2.length();   // asc order of length
        return s2.length() - s1.length();   // desc order of length
    }
}

class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2; // asc
//        return o2 - o1;   // desc

    }
}

public class PKComparator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.sort(new MyComparator());
        System.out.println("Ascending order: " + list);
        list.sort((a, b) -> b - a);    // desc order
        System.out.println("Descending order: " + list);

        System.out.println();

        List<String> words = Arrays.asList("banana", "apple", "date");
        words.sort(new StringLengthComparator());
        System.out.println("Descending order of length: " + words);
        words.sort((a, b) -> a.length() - b.length());  // asc order
//        words.sort((a, b) -> b.length() - a.length());  // desc order
        System.out.println("Ascending order of length: " + words);

        System.out.println();

        List<Student> students = new ArrayList<>();
        students.add(new Student("Charlie", 3.5));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Alice", 3.5));
        students.add(new Student("David", 3.9));

//        Method 1:
        students.sort((stud1, stud2) -> {
            if (stud2.getGpa() - stud1.getGpa() > 0) {
                return 1;
            } else if (stud2.getGpa() - stud1.getGpa() < 0) {
                return -1;
            } else {
                return 0;
//                return stud1.getName().compareTo(stud2.getName());    // this will sort name too in inc order after sorting wrt gpa
//                return stud2.getName().compareTo(stud1.getName());    // this will sort name too in desc order after sorting wrt gpa
            }
        });
        for (Student s : students) {
            System.out.println(s.getName() + ": " + s.getGpa());
        }

        System.out.println();

//        Method 2:
        Comparator<Student> comparator = Comparator.comparing(Student::getGpa); //asc
//        Comparator<Student> comparator2 = Comparator.comparing(Student::getGpa).reversed(); //desc
//        Comparator<Student> comparator3 = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName); //desc for gpa and then asc for name
        students.sort(comparator);
        for (Student s : students) {
            System.out.println(s.getName() + ": " + s.getGpa());
        }
    }
}