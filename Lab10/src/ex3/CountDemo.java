package ex3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

public class CountDemo {

    static void countFile(Path file) {
        try {
            List<String> lines = Files.readAllLines(file);

            int wordCount = 0;
            int charCount = 0;                // letters, digits, spaces and punctuation
            for (String line : lines) {
                charCount += line.length();
                if (!line.isBlank()) {
                    wordCount += line.trim().split("\\s+").length;
                }
            }

            System.out.println("File       : " + file);
            System.out.println("Lines      : " + lines.size());
            System.out.println("Words      : " + wordCount);
            System.out.println("Characters : " + charCount + " (not counting line breaks)");

        } catch (NoSuchFileException e) {
            System.out.println("Missing file: " + file);
        } catch (IOException e) {
            System.out.println("Could not read " + file + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        // Create a small sample file so this program runs on its own.
        // To count YOUR file, delete these two lines and change the name below.
        Path sample = Path.of("sample.txt");
        Files.write(sample, List.of(
                "Java is fun.",
                "Objects keep code organised.",
                "",
                "Files and streams are next!"));

        countFile(sample);
        System.out.println();
        countFile(Path.of("does-not-exist.txt"));
    }
}

