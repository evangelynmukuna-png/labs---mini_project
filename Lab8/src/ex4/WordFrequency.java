package ex4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {

        // To read a paragraph from the keyboard instead, use:
        //   String text = new java.util.Scanner(System.in).nextLine();
        String text = "The cat saw the dog and the dog saw the cat. " + "A bird saw the cat and the dog.";

        // 1. Split into lowercase words, ignoring punctuation
        String[] words = text.toLowerCase().split("[^a-z]+");

        // 2. Count with a Map: word -> how many times
        Map<String, Integer> counts = new HashMap<>();
        for (String w : words) {
            if (!w.isEmpty()) {
                counts.merge(w, 1, Integer::sum);       // add 1, or start at 1
            }
        }

        // 3. Sort the entries: highest count first, ties alphabetical
        List<Map.Entry<String, Integer>> entries = new java.util.ArrayList<>(counts.entrySet());
        entries.sort((a, b) -> {
            int byCount = Integer.compare(b.getValue(), a.getValue());     // descending
            return byCount != 0 ? byCount : a.getKey().compareTo(b.getKey());
        });

        // 4. Print
        System.out.printf("%-6s %s%n", "Word", "Count");
        for (Map.Entry<String, Integer> e : entries) {
            System.out.printf("%-6s %d%n", e.getKey(), e.getValue());
        }
    }
}

