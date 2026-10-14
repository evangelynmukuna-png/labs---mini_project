package ex4;

class InsufficientFundsException extends Exception {

    private final double shortfall;

    public InsufficientFundsException(double balance, double requested) {
        super(String.format("Cannot withdraw %.2f: balance is only %.2f", requested, balance));
        this.shortfall = requested - balance;
    }

    public double getShortfall() { return shortfall; }
}

class BankAccount {

    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    // BEFORE (Lab 3): public boolean withdraw(double amount)  ->  returned false on failure
    // NOW: failure is an exception, so the caller cannot silently ignore it
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }
        balance -= amount;
    }
}

public class BankDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", 800.00);

        try {
            acc.withdraw(300.00);
            System.out.println("Withdrew 300.00, balance = " + acc.getBalance());

            acc.withdraw(1000.00);            // fails
            System.out.println("This line is never reached");

        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.printf("You are short by %.2f%n", e.getShortfall());
        }

        System.out.println("Final balance = " + acc.getBalance());
    }
}

