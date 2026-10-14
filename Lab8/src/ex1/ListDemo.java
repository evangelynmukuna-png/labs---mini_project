package ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        int[] values = {20, 6, 39, 2, 28, 10, 50, 1, 18, 32};
        for (int v : values) {
            numbers.add(v);        // int is auto-boxed to Integer
        }

        System.out.println("List    : " + numbers);

        // Sum
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        System.out.println("Sum     : " + sum);

        // Maximum
        int max = numbers.get(0);
        for (int n : numbers) {
            if (n > max) {
                max = n;
            }
        }
        System.out.println("Maximum : " + max);
        System.out.println("(check) : " + Collections.max(numbers));

        // Reverse order: loop backwards, leaving the original list unchanged
        System.out.print("Reversed: ");
        for (int i = numbers.size() - 1; i >= 0; i--) {
            System.out.print(numbers.get(i) + (i > 0 ? ", " : "\n"));
        }

        // Or reverse a COPY with the Collections helper
        List<Integer> copy = new ArrayList<>(numbers);
        Collections.reverse(copy);
        System.out.println("Reversed copy: " + copy);
        System.out.println("Original still: " + numbers);
    }
}

