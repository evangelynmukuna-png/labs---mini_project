package ex5b;

abstract class Payment {
    private final double amount;

    Payment(double amount) { this.amount = amount; }

    double getAmount() { return amount; }

    abstract void process();      // every payment knows how to process itself
}


class CardPayment extends Payment {
    private final String last4;

    CardPayment(String last4, double amount) {
        super(amount);
        this.last4 = last4;
    }

    @Override
    void process() {
        System.out.printf("Card ending %s: charged %.2f%n", last4, getAmount());
    }
}

class MobileMoneyPayment extends Payment {
    private final String phone;

    MobileMoneyPayment(String phone, double amount) {
        super(amount);
        this.phone = phone;
    }

    @Override
    void process() {
        System.out.printf("Mobile money %s: sent %.2f%n", phone, getAmount());
    }
}

class CashPayment extends Payment {        // new type: processor is NOT touched
    CashPayment(double amount) { super(amount); }

    @Override
    void process() {
        System.out.printf("Cash: received %.2f%n", getAmount());
    }
}

// DESIGN 2: the processor just says process(). No type checks at all.
class PaymentProcessor {

    void pay(Payment p) {
        p.process();     // dynamic dispatch picks the right version
    }
}

public class PaymentDemoB {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        processor.pay(new CardPayment("5678", 200.00));
        processor.pay(new MobileMoneyPayment("0776815627", 80.00));
        processor.pay(new CashPayment(50.00));         // works immediately
    }
}

