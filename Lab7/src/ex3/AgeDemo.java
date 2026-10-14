package ex3;

// CHECKED exception: extends Exception (not RuntimeException)
class InvalidAgeException extends Exception {

    private final int age;

    public InvalidAgeException(int age) {
        super("Invalid age: " + age + " (must be between 0 and 120)");
        this.age = age;
    }

    public int getAge() { return age; }
}

public class AgeDemo {

    // "throws" is REQUIRED because the exception is checked
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException(age);
        }
        System.out.println("Age " + age + " is valid");
    }

    public static void main(String[] args) {
        int[] testAges = {40, 200, 0, -20, 120};

        for (int age : testAges) {
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Caught: " + e.getMessage());
            }
        }

        // validateAge(30);   // COMPILE ERROR: unreported exception InvalidAgeException;
        //                    // must be caught or declared to be thrown
    }
}

