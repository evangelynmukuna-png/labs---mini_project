package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addItem(LibraryItem item) {
        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException("An item with id " + item.getId() + " already exists");
        }
        items.put(item.getId(), item);
    }

    public void registerMember(Member member) {
        if (members.containsKey(member.getId())) {
            throw new IllegalArgumentException("A member with id " + member.getId() + " already exists");
        }
        members.put(member.getId(), member);
    }

    public Loan borrow(String memberId, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        return borrow(memberId, itemId, LocalDate.now());
    }

    public Loan borrow(String memberId, String itemId, LocalDate date)
            throws ItemNotAvailableException, MemberLimitExceededException {
        Member member = findMember(memberId);
        LibraryItem item = findItem(itemId);

        if (member.hasReachedLimit()) {
            throw new MemberLimitExceededException(member.getName() + " already has "
                    + Member.MAX_LOANS + " loans");
        }
        item.borrow(member);

        Loan loan = new Loan(item, member, date);
        member.addLoan(loan);
        loans.add(loan);
        return loan;
    }

    public Loan giveBack(String itemId) {
        LibraryItem item = findItem(itemId);
        Loan loan = loans.stream()
                .filter(l -> l.getItem() == item)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(item.getTitle() + " is not on loan"));

        item.giveBack();
        loan.getMember().removeLoan(loan);
        loans.remove(loan);
        return loan;
    }

    public List<LibraryItem> searchByTitle(String text) {
        return items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(text.toLowerCase()))
                .sorted(Comparator.comparing(LibraryItem::getTitle))
                .toList();
    }

    public List<Loan> listOverdue(LocalDate on) {
        return loans.stream()
                .filter(l -> l.isOverdue(on))
                .sorted(Comparator.comparing(Loan::getDueDate))
                .toList();
    }

    public List<LibraryItem> getAllItems() {
        return items.values().stream()
                .sorted(Comparator.comparing(LibraryItem::getId))
                .toList();
    }

    public List<Member> getAllMembers() {
        return members.values().stream()
                .sorted(Comparator.comparing(Member::getId))
                .toList();
    }

    public List<Loan> getLoans() {
        return List.copyOf(loans);
    }

    private Member findMember(String id) {
        Member m = members.get(id);
        if (m == null) throw new IllegalArgumentException("No member with id " + id);
        return m;
    }

    private LibraryItem findItem(String id) {
        LibraryItem i = items.get(id);
        if (i == null) throw new IllegalArgumentException("No item with id " + id);
        return i;
    }
}

