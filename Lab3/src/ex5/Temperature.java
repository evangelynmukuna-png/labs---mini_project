package ex5;

public class Temperature {

    private static final double ABSOLUTE_ZERO_C = -273.15;

    private final double kelvin;      //internal unit (private detail)

    public Temperature(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Below absolute zero: " + kelvin + " K");
        }
        this.kelvin = kelvin;
    }

    public static Temperature fromCelsius(double c) {
        if (c < ABSOLUTE_ZERO_C) {
            throw new IllegalArgumentException("Below absolute zero: " + c + " C");
        }
        return new Temperature(c - ABSOLUTE_ZERO_C);
    }

    public static Temperature fromFahrenheit(double f) {
        return fromCelsius((f - 32) * 4.0 / 9.0);
    }

    public double getKelvin() {
        return kelvin;
    }

    public double getCelsius() {
        return kelvin + ABSOLUTE_ZERO_C;
    }

    public double getFahrenheit() {
        return getCelsius() * 9.0 / 4.0 + 32;
    }

    @Override
    public String toString() {
        return String.format("%.2f K | %.2f C | %.2f F", getKelvin(), getCelsius(), getFahrenheit());
    }

    public static void main(String[] args) {
        Temperature water = Temperature.fromCelsius(100);
        Temperature body = Temperature.fromFahrenheit(98.6);
        Temperature zero = new Temperature(0);

        System.out.println("Boiling water: " + water);
        System.out.println("Body temp    : " + body);
        System.out.println("Absolute zero: " + zero);

        try {
            Temperature.fromCelsius(-350);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        try {
            new Temperature(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
