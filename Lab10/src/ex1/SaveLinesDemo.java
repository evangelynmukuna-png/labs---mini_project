package ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveLinesDemo {
    public static void main(String[] args) {
        Path file = Path.of("notes.txt");        // created in the working directory
        Scanner in = new Scanner(System.in);

        // 1. Collect five lines from the user
        List<String> lines = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Type line " + i + ":");
            lines.add(in.nextLine());
        }

        try {
            // 2. Save them (creates the file, or replaces it if it already exists)
            Files.write(file, lines);
            System.out.println("Saved " + lines.size() + " lines to " + file);

            // 3. Read them back
            List<String> loaded = Files.readAllLines(file);
            System.out.println("--- Read back from the file ---");
            for (int i = 0; i < loaded.size(); i++) {
                System.out.println((i + 1) + ": " + loaded.get(i));
            }

        } catch (IOException e) {
            System.out.println("File problem: " + e.getMessage());
        }
    }

}
