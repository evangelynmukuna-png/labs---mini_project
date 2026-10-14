package ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        // new ArrayList<>(...) because List.of(...) is immutable and cannot be changed
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Before: " + numbers);

        // A Predicate is a test: it takes a value and returns true or false
        Predicate<Integer> isEven = n -> n % 2 == 0;

        numbers.removeIf(isEven);                    // remove every element for which the test is true
        System.out.println("After : " + numbers);

        // Predicates can be combined
        List<Integer> more = new ArrayList<>(List.of(7, 14, 19, 27, 32, 43));
        Predicate<Integer> isBig = n -> n > 20;
        more.removeIf(isEven.or(isBig));                // remove if even OR big
        System.out.println("Removed even or > 20: " + more);
    }
}

