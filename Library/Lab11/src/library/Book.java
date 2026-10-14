package library;

public class Book extends LibraryItem {
    private final String author;

    public Book(String id, String title, String author) {
        super(id, title);
        this.author = Validation.requireText(author, "Author");
    }

    @Override
    public int loanPeriodDays() { return 14; }  // books: two weeks


    @Override
    public String typeName() { return "BOOK"; }

    @Override
    public String extraInfo() { return author; }

    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return "Book [" + getId() + "] " + getTitle() + " by " + author + " - " + status();
    }
}

