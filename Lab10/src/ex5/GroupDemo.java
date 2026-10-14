package ex5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

record Learner(String name, int roll, double gpa) {

    static Learner fromCsv(String line) {
        String[] p = line.split(",");
        return new Learner(p[0].trim(), Integer.parseInt(p[1].trim()), Double.parseDouble(p[2].trim()));
    }
}

public class GroupDemo {

    // Grade bands by GPA
    static String band(double gpa) {
        if (gpa >= 3.5) return "A";
        if (gpa >= 3.0) return "B";
        return "C";
    }

    public static void main(String[] args) throws IOException {
        Path csv = Path.of("learners.csv");

        // Create sample data if the file is not there yet
        if (!Files.exists(csv)) {
            Files.write(csv, List.of(
                    "Evangelyn,1,3.9", "Tariro,2,3.2", "Faith,3,3.1", "Merit,4,3.9",
                    "Kyla,5,2.4", "Allan,6,3.6", "Tanaka,7,2.9", "Tino,8,3.0"));
        }

        // 1. Load
        List<Learner> learners = new ArrayList<>();
        for (String line : Files.readAllLines(csv)) {
            if (!line.isBlank()) {
                learners.add(Learner.fromCsv(line));
            }
        }
        System.out.println("Loaded " + learners.size() + " learners");

        // 2. Group by band (TreeMap keeps the bands in order A, B, C)
        Map<String, List<Learner>> byBand = learners.stream()
                .collect(Collectors.groupingBy(l -> band(l.gpa()), TreeMap::new, Collectors.toList()));

        // 3. Write one report file per band
        for (Map.Entry<String, List<Learner>> entry : byBand.entrySet()) {
            String bandName = entry.getKey();
            List<Learner> members = entry.getValue();

            double avg = members.stream().mapToDouble(Learner::gpa).average().orElse(0);

            List<String> report = new ArrayList<>();
            report.add("Band " + bandName + " report");
            report.add("Learners: " + members.size() + "   Average GPA: " + String.format("%.2f", avg));
            for (Learner l : members) {
                report.add(String.format("  %-8s roll %d   gpa %.1f", l.name(), l.roll(), l.gpa()));
            }

            Path out = Path.of("report_" + bandName + ".txt");
            Files.write(out, report);
            System.out.println("Wrote " + out + " (" + members.size() + " learners)");
        }

        // 4. Show what is inside one of the files
        System.out.println("--- report_A.txt ---");
        Files.readAllLines(Path.of("report_A.txt")).forEach(System.out::println);
    }
}

