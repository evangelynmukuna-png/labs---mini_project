package ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {

    private final String name;
    private final int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    String getName() { return name; }
    int getMarks()   { return marks; }

    // NATURAL ORDER: alphabetical by name
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}

public class SortDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Evangelyn", 90));
        list.add(new Student("Tariro", 82));
        list.add(new Student("Faith", 48));
        list.add(new Student("Merit", 100));

        // 1. Natural order (Comparable): by name
        Collections.sort(list);
        System.out.println("By name        : " + list);

        // 2. A separate Comparator: by marks, lowest first
        Comparator<Student> byMarks = Comparator.comparingInt(Student::getMarks);
        list.sort(byMarks);
        System.out.println("By marks (asc) : " + list);

        // 3. The same Comparator reversed: highest first
        list.sort(byMarks.reversed());
        System.out.println("By marks (desc): " + list);
    }
}

