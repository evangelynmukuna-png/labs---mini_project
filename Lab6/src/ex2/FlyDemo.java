package ex2;

interface Flyable {
    void fly();           // implicitly public abstract
}

// Two completely unrelated class families
class Animal {
    void eat() { System.out.println("Eating..."); }
}

class Vehicle {
    void start() { System.out.println("Engine starting..."); }
}

class Bird extends Animal implements Flyable {
    @Override
    public void fly() { System.out.println("Bird flaps its wings and flies"); }
}

class Aeroplane extends Vehicle implements Flyable {
    @Override
    public void fly() { System.out.println("Aeroplane takes off from the runway"); }
}

public class FlyDemo {
    public static void main(String[] args) {
        // Bird and Aeroplane share NO superclass, but both are Flyable
        Flyable[] flyers = { new Bird(), new Aeroplane() };

        for (Flyable f : flyers) {
            f.fly();
        }

        // Each object still keeps its own inherited behaviour
        new Bird().eat();
        new Aeroplane().start();
    }
}

