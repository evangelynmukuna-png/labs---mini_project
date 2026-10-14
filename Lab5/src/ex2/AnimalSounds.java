package ex2;

class Animal {
    void sound() {
        System.out.println("Some generic animal sound");
    }
}

class Bird extends Animal {
    @Override
    void sound() { System.out.println("Chirp"); }
}

class Sheep extends Animal {
    @Override
    void sound() { System.out.println("Bleat"); }
}

class Monkey extends Animal {
    @Override
    void sound() { System.out.println("Screech"); }
}

public class AnimalSounds {
    public static void main(String[] args) {
        // Upcasting: one array type holds three different subclasses
        Animal[] animals = { new Bird(), new Sheep(), new Monkey(), new Animal() };

        for (Animal a : animals) {
            // The JVM picks sound() from the ACTUAL object at run time
            System.out.print(a.getClass().getSimpleName() + ": ");
            a.sound();
        }
    }

}
