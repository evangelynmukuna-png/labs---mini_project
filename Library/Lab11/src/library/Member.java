package library;

import java.util.ArrayList;
import java.util.List;

public class Member {
    public static final int MAX_LOANS = 3;

    private final String id;
    private final String name;
    private final List<Loan> loans = new ArrayList<>();

    public Member(String id, String name) {
        this.id = Validation.requireText(id, "Member id");
        this.name = Validation.requireText(name, "Name");
    }

    public boolean hasReachedLimit() {
        return loans.size() >= MAX_LOANS;
    }

    void addLoan(Loan loan)    { loans.add(loan); }
    void removeLoan(Loan loan) { loans.remove(loan); }

    public String getId()   { return id; }
    public String getName() { return name; }

    public List<Loan> getLoans() { return List.copyOf(loans); }

    @Override
    public String toString() {
        return String.format("[%s] %s (%d/%d loans)", id, name, loans.size(), MAX_LOANS);
    }
}

