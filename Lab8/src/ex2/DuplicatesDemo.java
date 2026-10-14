package ex2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Evangelyn", "Tariro", "Faith", "Evangelyn", "Merit", "Tariro", "Tanaka", "Faith");

        System.out.println("Original (" + names.size() + "): " + names);

        // LinkedHashSet: removes duplicates AND keeps the original order
        Set<String> unique = new LinkedHashSet<>(names);
        System.out.println("Unique, same order (" + unique.size() + "): " + unique);

        // Back to a List if you need one
        List<String> cleanList = new ArrayList<>(unique);
        System.out.println("As a list: " + cleanList);

        // A plain HashSet also removes duplicates, but the order is not guaranteed
        Set<String> hashSet = new HashSet<>(names);
        System.out.println("HashSet size: " + hashSet.size() + " (order not guaranteed)");

        // add() tells you whether the element was new
        System.out.println("add(\"Merit\")  -> " + unique.add("Merit"));
        System.out.println("add(\"Kyla\") -> " + unique.add("Kyla"));
    }
}

