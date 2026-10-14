package ex4;

class Animal {

    private String name;

    public Animal(String name) {     // the ONLY constructor, and it needs a name
        this.name = name;
        System.out.println("Animal constructor: " + name);
    }

    public String getName() { return name; }
}

// FIX 1: call the parent constructor explicitly with super(name)
class Dog extends Animal {

    public Dog(String name) {
        super(name);
        System.out.println("Dog constructor: " + name);
    }
}

// FIX 2 (alternative): the subclass supplies a default name itself
class Cat extends Animal {

    public Cat() {
        super("Unnamed cat");        // still must call a constructor that exists
        System.out.println("Cat constructor");
    }
}

public class AnimalDemo {
    public static void main(String[] args) {
        Dog d = new Dog("Scooby");
        System.out.println("---");
        Cat c = new Cat();
        System.out.println("---");
        System.out.println(d.getName() + " and " + c.getName());
    }

}
