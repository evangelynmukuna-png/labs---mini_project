package ex2;

record Student(String name, int age) { }

public class RecordDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Tariro", 20);
        Student s2 = new Student("Tariro", 20);
        Student s3 = new Student("Faith", 22);

        // 1. Print: toString() is generated automatically
        System.out.println(s1);

        // 2. Compare: equals() compares the VALUES of the components
        System.out.println("s1.equals(s2) = " + s1.equals(s2));
        System.out.println("s1 == s2      = " + (s1 == s2));   // different objects
        System.out.println("s1.equals(s3) = " + s1.equals(s3));
        System.out.println("same hashCode = " + (s1.hashCode() == s2.hashCode()));

        // 3. Read a component: use name(), not getName()
        System.out.println("name = " + s1.name());
        System.out.println("age  = " + s1.age());
    }
}

