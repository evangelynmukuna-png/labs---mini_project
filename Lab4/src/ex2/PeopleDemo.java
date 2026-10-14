package ex2;

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age );
    }
}

class Student extends Person{
    private String course;

    public Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }

    public String getCourse() { return course; }
}

class Teacher extends Person {       // a second subclass of the SAME parent
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public String getSubject() { return subject; }
}

public class PeopleDemo {
    public static void main(String[] args) {
        Student s = new Student("Evangelyn", 20, "Software Engineering");
        Teacher t = new Teacher("Mr Chiworera",  39, "OOP");

        System.out.println("--- Student ---");
        s.display();                                            // Person's code
        System.out.println("Course: " + s.getCourse());

        System.out.println("--- Teacher ---");
        t.display();                                           // the SAME Person code
        System.out.println("Subject: " + t.getSubject());

        // Both are Persons, so the shared code works on either
        System.out.println("--- Shared getName() ---");
        System.out.println(s.getName() + " and " + t.getName());
    }
}
