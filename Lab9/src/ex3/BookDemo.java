package ex3;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {

    private final String isbn;
    private final String title;

    Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    // Two books are equal when their ISBN is equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book other)) return false;
        return isbn.equals(other.isbn);
    }

    // MUST use the same field(s) as equals
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return title + " [" + isbn + "]";
    }
}

public class BookDemo {
    public static void main(String[] args) {
        Book b1 = new Book("978-0134685991", "Effective Java");
        Book b2 = new Book("978-0134685991", "Effective Java (2nd copy)");   // same ISBN
        Book b3 = new Book("978-0596009205", "Head First Java");

        System.out.println("b1.equals(b2) = " + b1.equals(b2));
        System.out.println("same hashCode = " + (b1.hashCode() == b2.hashCode()));

        Set<Book> library = new HashSet<>();
        System.out.println("add b1 -> " + library.add(b1));
        System.out.println("add b2 -> " + library.add(b2));    // rejected : duplicate ISBN
        System.out.println("add b3 -> " + library.add(b3));

        System.out.println("Set size = " + library.size());
        System.out.println("contains new Book with the same ISBN? " + library.contains(new Book("788-004744356805", "anything")));
    }
}

