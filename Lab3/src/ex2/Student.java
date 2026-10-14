package ex2;

public class Student {

    private String name;
    private int marks;

    public Student(String name, int marks) {
        setName(name);
        setMarks(marks);
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

    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    // Calculated from marks every time, so it can never go out of date
    public String getGrade() {
        if (marks >= 75) return "A";
        if (marks >= 65) return "B";
        if (marks >= 50) return "C";
        return "F";
    }

    public static void main(String[] args) {
        Student s = new Student("Evangelyn", 90);
        System.out.println(s.getName() + ": " + s.getMarks() + " -> " + s.getGrade());

        s.setMarks(70);
        System.out.println(s.getName() + ": " + s.getMarks() + " -> " + s.getGrade());

        s.setMarks(60);
        System.out.println(s.getName() + ": " + s.getMarks() + " -> " + s.getGrade());

        s.setMarks(40);
        System.out.println(s.getName() + ": " + s.getMarks() + " -> " + s.getGrade());
    }
}
