package ex4;

class Parent {
    String label = "Parent field";

    void speak() {
        System.out.println("Parent method");
    }

    static void info() {
        System.out.println("Parent static method");
    }
}

class Child extends Parent {
    String label = "Child field";               // HIDES the parent's field (not an override)

    @Override
    void speak() {            // OVERRIDES the parent's method
        System.out.println("Child method");
    }

    static void info() {            // HIDES the parent's static method
        System.out.println("Child static method");
    }
}

public class AccessDemo {
    public static void main(String[] args) {
        Parent p = new Child();

        System.out.println("--- through a Parent reference ---");
        p.speak();                            // METHOD: decided by the real object
        System.out.println(p.label);          // FIELD: decided by the declared type
        p.info();                             // STATIC: decided by the declared type

        System.out.println("--- through a Child reference ---");
        Child c = new Child();
        c.speak();
        System.out.println(c.label);
        c.info();

        System.out.println("--- same object, cast to Child ---");
        System.out.println(((Child) p).label);
    }
}


