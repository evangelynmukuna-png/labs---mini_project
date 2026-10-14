import java.time.Year;

public class Car {
    String brand;
    int year;
    double mileage;

    void display() {
        System.out.println("Brand: " + brand + ", Year: " + year + ", Mileage: " + mileage + "km");
    }

    boolean isAntique() {
        return Year.now().getValue() - year > 25;
    }
}
