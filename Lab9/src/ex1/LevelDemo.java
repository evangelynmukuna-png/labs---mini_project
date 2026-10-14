package ex1;

enum Level { LOW, MEDIUM, HIGH }

public class LevelDemo {

    static void advice(Level level) {
        switch (level) {
            case LOW    -> System.out.println("LOW: relax, nothing needs attention.");
            case MEDIUM -> System.out.println("MEDIUM: keep an eye on it and plan ahead.");
            case HIGH   -> System.out.println("HIGH: act now, this is urgent!");
        }
    }

    public static void main(String[] args) {
        // Loop through every constant
        for (Level l : Level.values()) {
            advice(l);
        }

        System.out.println("---");

        // Other useful enum features
        Level chosen = Level.valueOf("MEDIUM");   // text to enum
        System.out.println("chosen   = " + chosen);
        System.out.println("ordinal  = " + chosen.ordinal());      // position, starting at 0
        System.out.println("HIGH after MEDIUM? " + (Level.HIGH.compareTo(chosen) > 0));
    }
}
