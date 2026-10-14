package library;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LibraryStore store = new LibraryStore("data");
        Library library;
        try {
            library = store.load();
            System.out.println("Loaded " + library.getAllItems().size() + " items, "
                    + library.getAllMembers().size() + " members, "
                    + library.getLoans().size() + " loans.");
        } catch (IOException e) {
            System.out.println("Could not load saved data: " + e.getMessage());
            library = new Library();
        }

        Scanner in = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printMenu();
            String choice = in.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> addItem(library, in);
                    case "2" -> registerMember(library, in);
                    case "3" -> borrow(library, in);
                    case "4" -> giveBack(library, in);
                    case "5" -> listOverdue(library, in);
                    case "6" -> search(library, in);
                    case "7" -> listAll(library);
                    case "0" -> running = false;
                    default -> System.out.println("Invalid choice, try again.");
                }
            } catch (ItemNotAvailableException | MemberLimitExceededException
                     | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        try {
            store.save(library);
            System.out.println("Data saved. Goodbye!");
        } catch (IOException e) {
            System.out.println("Could not save data: " + e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===== Library Menu =====");
        System.out.println("1. Add item");
        System.out.println("2. Register member");
        System.out.println("3. Borrow item");
        System.out.println("4. Return item");
        System.out.println("5. List overdue items");
        System.out.println("6. Search by title");
        System.out.println("7. List everything");
        System.out.println("0. Save and exit");
        System.out.print("Choice: ");
    }

    private static String ask(Scanner in, String prompt) {
        System.out.print(prompt);
        return in.nextLine().trim();
    }

    private static void addItem(Library library, Scanner in) {
        String type = ask(in, "Type (1 = Book, 2 = DVD): ");
        String id = ask(in, "Item id: ");
        String title = ask(in, "Title: ");
        switch (type) {
            case "1" -> library.addItem(new Book(id, title, ask(in, "Author: ")));
            case "2" -> library.addItem(new Dvd(id, title, Integer.parseInt(ask(in, "Runtime (minutes): "))));
            default -> throw new IllegalArgumentException("Type must be 1 or 2");
        }
        System.out.println("Item added.");
    }

    private static void registerMember(Library library, Scanner in) {
        String id = ask(in, "Member id: ");
        String name = ask(in, "Name: ");
        library.registerMember(new Member(id, name));
        System.out.println("Member registered.");
    }

    private static void borrow(Library library, Scanner in)
            throws ItemNotAvailableException, MemberLimitExceededException {
        String memberId = ask(in, "Member id: ");
        String itemId = ask(in, "Item id: ");
        Loan loan = library.borrow(memberId, itemId);
        System.out.println("Borrowed: " + loan);
    }

    private static void giveBack(Library library, Scanner in) {
        String itemId = ask(in, "Item id: ");
        Loan loan = library.giveBack(itemId);
        System.out.println("Returned: " + loan.getItem().getTitle());
    }

    private static void listOverdue(Library library, Scanner in) {
        int days = Integer.parseInt(ask(in, "Days from today to check (0 = today): "));
        LocalDate on = LocalDate.now().plusDays(days);
        List<Loan> overdue = library.listOverdue(on);
        System.out.println("Overdue on " + on + ": " + overdue.size());
        overdue.forEach(l -> System.out.println("  " + l));
    }

    private static void search(Library library, Scanner in) {
        String text = ask(in, "Title contains: ");
        List<LibraryItem> found = library.searchByTitle(text);
        if (found.isEmpty()) {
            System.out.println("No matches.");
        } else {
            found.forEach(i -> System.out.println("  " + i));
        }
    }

    private static void listAll(Library library) {
        System.out.println("-- Items --");
        library.getAllItems().forEach(i -> System.out.println("  " + i));
        System.out.println("-- Members --");
        library.getAllMembers().forEach(m -> System.out.println("  " + m));
    }
}

