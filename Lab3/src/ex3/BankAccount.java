package ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {

    private final String accountNumber;
    private String ownerName;
    private double balance;
    private final List<String> history = new ArrayList<>();     // private and final

    public BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        setOwnerName(ownerName);
        this.balance = openingBalance;
        history.add(String.format("OPEN     %.2f", openingBalance));
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName()     { return ownerName; }
    public double getBalance()       { return balance; }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name required");
        }
        this.ownerName = ownerName.trim();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
        history.add(String.format("DEPOSIT  %.2f", amount));
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            history.add(String.format("FAILED   %.2f (insufficient funds)", amount));
            return false;
        }
        balance -= amount;
        history.add(String.format("WITHDRAW %.2f", amount));
        return true;
    }

    // Returns an UNMODIFIABLE COPY: a snapshot nobody can change
    public List<String> getHistory() {
        return Collections.unmodifiableList(new ArrayList<>(history));
    }

    @Override
    public String toString() {
        return String.format("%s [%s] balance: %.2f", accountNumber, ownerName, balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 750.00);
        acc.deposit(200.00);
        acc.withdraw(150.00);
        acc.withdraw(1000.00);

        System.out.println(acc);
        System.out.println("--- Transaction history ---");
        for (String entry : acc.getHistory()) {
            System.out.println(entry);
        }

        // Try to tamper with the history from outside
        try {
            acc.getHistory().clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("Tampering blocked: history is read-only");
        }

        // The snapshot is a copy, so later transactions do not change it
        List<String> snapshot = acc.getHistory();
        acc.deposit(50.00);
        System.out.println("Snapshot size: " + snapshot.size());
        System.out.println("Live history size: " + acc.getHistory().size());
    }

}
