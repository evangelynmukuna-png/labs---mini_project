package ex3;

abstract class Account {

    private final String owner;
    protected double balance;

    Account(String owner, double openingBalance) {
        this.owner = owner;
        this.balance = openingBalance;
    }

    // Concrete: identical for every kind of account
    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    // Abstract: each account type has its own fee rule
    abstract double monthlyFee();

    // Concrete method that relies on the abstract one
    void applyMonthlyFee() {
        balance -= monthlyFee();
    }

    String getOwner()   { return owner; }
    double getBalance() { return balance; }
}

class SavingsAccount extends Account {

    SavingsAccount(String owner, double openingBalance) {
        super(owner, openingBalance);
    }

    @Override
    double monthlyFee() {
        return balance >= 500 ? 0.0 : 3.0;
    }          // free when the balance is 500 or more
}

class CurrentAccount extends Account {

    CurrentAccount(String owner, double openingBalance) {
        super(owner, openingBalance);
    }

    @Override
    double monthlyFee() {
        return 12.0;
    }              // flat free
}

public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = {
                new SavingsAccount("Evangelyn", 1000),
                new SavingsAccount("Tariro", 400),
                new CurrentAccount("Faith", 1200)
        };

        for (Account a : accounts) {
            a.deposit(100);               // shared account from Account
            double before = a.getBalance();
            a.applyMonthlyFee();          // each type charges its own fee
            System.out.printf("%-8s %-15s fee = %5.2f   balance %.2f -> %.2f%n",
                    a.getOwner(), a.getClass().getSimpleName(), a.monthlyFee(),
                    before, a.getBalance());
        }
    }
}

