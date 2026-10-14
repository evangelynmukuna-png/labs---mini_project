package ex5;

import java.util.EnumMap;
import java.util.Map;

enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    private final int cents;

    Coin(int cents) { this.cents = cents; }

    int getCents() { return cents; }

    // Fewest coins: always take as many of the largest coin as possible
    static Map<Coin, Integer> makeChange(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        Map<Coin, Integer> result = new EnumMap<>(Coin.class);
        Coin[] all = Coin.values();
        for (int i = all.length - 1; i >= 0; i--) {          // QUARTER first, PENNY last
            Coin coin = all[i];
            int count = amount / coin.cents;
            if (count > 0) {
                result.put(coin, count);
                amount -= count * coin.cents;
            }
        }
        return result;
    }

    static int totalCoins(Map<Coin, Integer> change) {
        int total = 0;
        for (int n : change.values()) {
            total += n;
        }
        return total;
    }
}

public class CoinDemo {
    public static void main(String[] args) {
        int[] amounts = {72, 100, 8, 55, 0};

        for (int amount : amounts) {
            Map<Coin, Integer> change = Coin.makeChange(amount);
            System.out.println(amount + " cents -> " + change + "  (" + Coin.totalCoins(change) + " coins)");
        }
    }
}

