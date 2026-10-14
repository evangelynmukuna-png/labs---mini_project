package ex3;

class Vehicle{
    private String brand;

    public Vehicle(String brand) {
        this.brand = brand;
        System.out.println("1. Vehicle constructor: brand = " + brand);
    }
    public String getBrand() { return brand; }
}

class Car extends Vehicle {
    private int doors;

    public Car(String brand, int doors) {
        super(brand);                // runs Vehicle's constructor first
        this.doors = doors;
        System.out.println("2. Car constructor: doors = " + doors);
    }
    public int getDoors() { return doors; }
}

class ElectricCar extends Car {
    private int batterykWh;

    public ElectricCar(String brand, int doors, int batterykWh) {
        super(brand, doors);                    // runs Car's constructor first
        this.batterykWh = batterykWh;
        System.out.println("3. ElectricCar constructor: battery = " + batterykWh + " kWh");
    }
    public int getBatterykWh() { return batterykWh; }
}

public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Creating an ElectricCar...");
        ElectricCar e = new ElectricCar("Tesla", 4, 75);

        System.out.println("Done. Brand=" + e.getBrand() + ", doors=" + e.getDoors() + ", battery=" + e.getBatterykWh() + "kWh");
    }
}
