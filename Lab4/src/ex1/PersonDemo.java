package ex1;

class Person{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {return name; }
    public int getAge() {return age; }

    // Written ONCE here; every subclass inherits it
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Student extends Person {      // Student IS-A Person

    private String course;

    public Student(String name, int age, String course) {
        super(name, age);       // run Person's constructor first
        this.course = course;
    }

    public String getCourse() { return course; }
}

public class PersonDemo {
    public static void main(String[] args) {
        Person p = new Person("Allan", 24);
        Student s = new Student("Evangelyn", 20, "Software Engineering");

        System.out.println("--- Person ---");
        p.display();

        System.out.println("--- Student ---");
        s.display();                                                  // inherited from Person
        System.out.println("Course: " + s.getCourse());               // added by Student
    }
}
