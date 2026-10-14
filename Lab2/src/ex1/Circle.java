package ex1;

public class Circle {
    private double radius;

    // Constructor 1: takes the radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Constructor 2: no argument, deafults to 1.0 (chains to constructor 1)
    public Circle() {
        this(1.0);
    }

    public double getRadius() {
        return radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(6.5);
        Circle c2 = new Circle();

        System.out.printf("c1 radius = %.1f, area = %.2f%n", c1.getRadius(), c1.area());
        System.out.printf("c2 radius = %.1f, area = %.2f%n", c2.getRadius(), c2.area());
    }
}
