package library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class LibraryStore {
    private final Path folder;
    private final Path itemsFile;
    private final Path membersFile;
    private final Path loansFile;

    public LibraryStore(String folderName) {
        this.folder = Path.of(folderName);
        this.itemsFile = folder.resolve("items.csv");
        this.membersFile = folder.resolve("members.csv");
        this.loansFile = folder.resolve("loans.csv");
    }

    public void save(Library library) throws IOException {
        Files.createDirectories(folder);

        List<String> itemLines = new ArrayList<>();
        for (LibraryItem i : library.getAllItems()) {
            itemLines.add(i.typeName() + "," + i.getId() + "," + i.getTitle() + "," + i.extraInfo());
        }
        Files.write(itemsFile, itemLines);

        List<String> memberLines = new ArrayList<>();
        for (Member m : library.getAllMembers()) {
            memberLines.add(m.getId() + "," + m.getName());
        }
        Files.write(membersFile, memberLines);

        List<String> loanLines = new ArrayList<>();
        for (Loan l : library.getLoans()) {
            loanLines.add(l.getMember().getId() + "," + l.getItem().getId() + "," + l.getBorrowDate());
        }
        Files.write(loansFile, loanLines);
    }

    public Library load() throws IOException {
        Library library = new Library();

        if (Files.exists(itemsFile)) {
            for (String line : Files.readAllLines(itemsFile)) {
                if (line.isBlank()) continue;
                try {
                    String[] p = line.split(",");
                    switch (p[0]) {
                        case "BOOK" -> library.addItem(new Book(p[1], p[2], p[3]));
                        case "DVD"  -> library.addItem(new Dvd(p[1], p[2], Integer.parseInt(p[3])));
                        default -> System.out.println("Skipped unknown item type: " + line);
                    }
                } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Skipped bad item line: " + line);
                }
            }
        }

        if (Files.exists(membersFile)) {
            for (String line : Files.readAllLines(membersFile)) {
                if (line.isBlank()) continue;
                try {
                    String[] p = line.split(",");
                    library.registerMember(new Member(p[0], p[1]));
                } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Skipped bad member line: " + line);
                }
            }
        }

        if (Files.exists(loansFile)) {
            for (String line : Files.readAllLines(loansFile)) {
                if (line.isBlank()) continue;
                try {
                    String[] p = line.split(",");
                    library.borrow(p[0], p[1], LocalDate.parse(p[2]));
                } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException
                         | DateTimeParseException | ItemNotAvailableException
                         | MemberLimitExceededException e) {
                    System.out.println("Skipped bad loan line: " + line);
                }
            }
        }
        return library;
    }
}

