package library;

/** Contract for anything that can be lent out. */
public interface Borrowable {
    void borrow(Member member) throws ItemNotAvailableException;

    void giveBack();
}

