package ex5;

interface Greeter {
    default void hello() {
        System.out.println("Hello from Greeter");
    }
}

interface Welcomer {
    default void hello() {
        System.out.println("Hello from Welcomer");
    }
}

// Without the override below, this class would NOT compile
class Person implements Greeter, Welcomer {

    @Override
    public void hello() {
        Greeter.super.hello();          // choose Greeter's version explicitly
        Welcomer.super.hello();         // and/or Welcomer's version
        System.out.println("Hello from Person itself");
    }
}

public class DefaultDemo {
    public static void main(String[] args) {
        new Person().hello();
    }
}
