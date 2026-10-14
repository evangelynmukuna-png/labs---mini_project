package ex1;

public class Student {

    private String name;
    private int marks;

    public Student(String name, int marks) {
        setName(name);                   // reuse validation
        setMarks(marks);                 // reuse validation
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name required");
        }
        this.name = name.trim();
    }

    public int getMarks() {
        return marks;
    }

    // Setter with validation: marks must be 0 to 100
    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    public static void main(String[] args) {
        Student s = new Student("Evangelyn", 88);
        System.out.println(s.getName() + " has " + s.getMarks() + " marks");

        s.setMarks(95);
        System.out.println("Updated marks: " + s.getMarks());

        // s.marks = 500;   // COMPILE ERROR: marks has private access

        try {
            s.setMarks(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        try {
            s.setMarks(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        System.out.println("Marks still: " + s.getMarks());
    }
}
