package ex4;

import java.util.List;
import java.util.stream.Collectors;

record Student(String name, int marks) { }

public class AboveAverage {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Evangelyn", 100),
                new Student("Tariro", 82),
                new Student("Faith", 48),
                new Student("Merit", 91),
                new Student("Kyla", 74));

        // 1. The class average
        double average = students.stream()
                .mapToInt(Student::marks)
                .average()
                .orElse(0);
        System.out.println("Class average = " + average);

        // 2. Names above the average, sorted alphabetically
        List<String> above = students.stream()
                .filter(s -> s.marks() > average)
                .map(Student::name)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Above average: " + above);

        // The same thing, printing one name per line
        System.out.println("--- one per line ---");
        students.stream()
                .filter(s -> s.marks() > average)
                .map(Student::name)
                .sorted()
                .forEach(System.out::println);
    }
}

