package ex4;

import java.time.LocalDate;

public class ImmutablePerson {     // final class: cannot be subclassed

    private final String name;       // final fields: set once, in the constructor
    private final LocalDate dateOfBirth;    // LocalDate is itself immutable, so safe to store
    public ImmutablePerson(String name, LocalDate dateOfBirth) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name required");
        }
        if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid date of birth");
        }
        this.name = name.trim();
        this.dateOfBirth = dateOfBirth;
    }

    // Getters only. NO setters.
    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    // "Changing" a value returns a NEW object; the original stays the same
    public ImmutablePerson withName(String newName) {
        return new ImmutablePerson(newName, dateOfBirth);
    }

    @Override
    public String toString() {
        return name + " (born " + dateOfBirth + ")";
    }

    public static void main(String[] args) {
        ImmutablePerson p1 = new ImmutablePerson("Evangelyn", LocalDate.of(2006, 8, 28));
        ImmutablePerson p2 = p1.withName("Tariro");

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p1 unchanged: " + p1.getName());

        // p1.name = "Hacker";       // COMPILE ERROR: private and final
        // p1.setName("Hacker");     // COMPILE ERROR: no such method

        try {
            new ImmutablePerson("  ", LocalDate.of(2000, 1, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
