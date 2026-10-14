package library;

import java.util.Objects;

/** Abstract parent of Book and Dvd. Shows abstraction, inheritance and polymorphism. */
public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;
    private Member borrowedBy;

    protected LibraryItem(String id, String title) {
        this.id = Validation.requireText(id, "Item id");
        this.title = Validation.requireText(title, "Title");
    }

    // Each subclass decides its own values (polymorphism)
    public abstract int loanPeriodDays();
    public abstract String typeName();
    public abstract String extraInfo();

    @Override
    public void borrow(Member member) throws ItemNotAvailableException {
        Objects.requireNonNull(member, "member");
        if (!available) {
            throw new ItemNotAvailableException(title + " (" + id + ") is already on loan");
        }
        available = false;
        borrowedBy = member;
    }

    @Override
    public void giveBack() {
        available = true;
        borrowedBy = null;
    }

    public String getId()          { return id; }
    public String getTitle()       { return title; }
    public boolean isAvailable()   { return available; }
    public Member getBorrowedBy()  { return borrowedBy; }

    protected String status() {
        return available ? "available" : "on loan to " + borrowedBy.getName();
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s", id, title, status());
    }
}
