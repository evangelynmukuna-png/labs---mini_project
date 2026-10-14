package library;

public class Dvd extends LibraryItem {
    private final int runtimeMinutes;

    public Dvd(String id, String title, int runtimeMinutes) {
        super(id, title);
        if (runtimeMinutes <= 0) {
            throw new IllegalArgumentException("Runtime must be positive");
        }
        this.runtimeMinutes = runtimeMinutes;
    }

    @Override
    public int loanPeriodDays() { return 7; }

    @Override
    public String typeName() { return "DVD"; }

    @Override
    public String extraInfo() { return String.valueOf(runtimeMinutes); }

    public int getRuntimeMinutes() { return runtimeMinutes; }

    @Override
    public String toString() {
        return "DVD [" + getId() + "] " + getTitle() + " (" + runtimeMinutes + " min) - " + status();
    }
}

