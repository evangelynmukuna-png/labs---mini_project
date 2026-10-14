package ex5a;

class Payment {
    private final double amount;
    Payment(double amount) { this.amount = amount; }
    double getAmount() { return amount; }
}

class CardPayment extends Payment {
    private final String last4;

    CardPayment(String last4, double amount) {
        super(amount);
        this.last4 = last4;
    }
    String getLast4() { return last4; }
}

class MobileMoneyPayment extends Payment {
    private final String phone;

    MobileMoneyPayment(String phone, double amount) {
        super(amount);
        this.phone = phone;
    }

    String getPhone() { return phone; }
}

class CashPayment extends Payment {                // added later
    CashPayment(double amount) { super(amount); }
}

// DESIGN 1: the processor asks "what type are you?" with instanceof
class PaymentProcessor {

    void pay(Payment p) {
        if (p instanceof CardPayment c) {              // test AND cast in one step
            System.out.printf("Card ending %s: charged %.2f%n", c.getLast4(), c.getAmount());
        } else if (p instanceof MobileMoneyPayment m) {
            System.out.printf("Mobile money %s: sent %.2f%n", m.getPhone(), m.getAmount());
        } else {
            System.out.println("Unsupported payment type: " + p.getClass().getSimpleName());
        }
    }
}

public class PaymentDemoA {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        processor.pay(new CardPayment("5678", 200.00));
        processor.pay(new MobileMoneyPayment("0776815627", 80.00));
        processor.pay(new CashPayment(50.00));           // compiles fine, but is NOT handled
    }
}

