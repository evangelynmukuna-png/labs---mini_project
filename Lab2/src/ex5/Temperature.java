package ex5;

public class Temperature {
    private final double celcius;        // stores one unit internally

    // Private: outsiders must use the factory methods
    private Temperature(double celcius) {
        this.celcius = celcius;
    }

    public static Temperature fromCelcius(double c) {return new Temperature(c);
    }

    public static Temperature fromFahrenheit(double f) {
        return new Temperature((f - 32) * 4.0 / 9.0);
    }

    public double toCelcius() {
        return celcius;
    }

    public double toFahrenheit() {
        return celcius * 9.0 / 4.0 + 32;
    }

    @Override
    public String toString() {
        return String.format("%.1f\u00B0C / %.1f\u00B0F", toCelcius(), toFahrenheit());
    }

    public static void main(String[] args) {
        Temperature boiling = Temperature.fromCelcius(100);
        Temperature body = Temperature.fromFahrenheit(98.6);
        Temperature freezing = Temperature.fromFahrenheit(32);

        System.out.println("Boiling : " + boiling);
        System.out.println("Body : " + body);
        System.out.println("Freezing : " + freezing);
    }
}
