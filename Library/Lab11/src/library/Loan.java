package library;

import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    private final LibraryItem item;
    private final Member member;
    private final LocalDate borrowDate;

    public Loan(LibraryItem item, Member member, LocalDate borrowDate) {
        this.item = Objects.requireNonNull(item, "item");
        this.member = Objects.requireNonNull(member, "member");
        this.borrowDate = Objects.requireNonNull(borrowDate, "borrowDate");
    }

    public LibraryItem getItem()      { return item; }
    public Member getMember()         { return member; }
    public LocalDate getBorrowDate()  { return borrowDate; }

    public LocalDate getDueDate() {
        return borrowDate.plusDays(item.loanPeriodDays());
    }

    public boolean isOverdue(LocalDate on) {
        return on.isAfter(getDueDate());
    }

    @Override
    public String toString() {
        return String.format("%s -> %s, borrowed %s, due %s",
                item.getTitle(), member.getName(), borrowDate, getDueDate());
    }
}
