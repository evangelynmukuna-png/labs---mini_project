public class CarDemo {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.brand = "Toyota"; c1.year = 1998; c1.mileage = 216000;
        Car c2 = new Car(); c2.brand = "Honda"; c2.year = 2016; c2.mileage = 66000;
        Car c3 = new Car(); c3.brand = "BMW"; c3.year = 1980; c3.mileage = 32000;

        c1.display();
        c2.display();
        c3.display();
        System.out.println(c1.brand + "antique? " + c1.isAntique());
        System.out.println(c2.brand + "antique? " + c2.isAntique());
        System.out.println(c3.brand + "antique? " + c3.isAntique());
    }
}
