package ex2;

public class Circle {

    // ONE copy shared by every Circle object
    private static int count = 0;

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        count++;
    }

    public Circle() {
        this(1.0);          // goes through the constructor above, so count++ runs once
    }

    public static int getCount() {
        return count;
    }

    public double getRadius() {
        return radius;
    }

    public static void main(String[] args) {
        System.out.println("Circles before: " + Circle.getCount());

        Circle c1 = new Circle(3.5);
        Circle c2 = new Circle();
        Circle c3 = new Circle(9);

        System.out.println("Circles after: " + Circle.getCount());
        System.out.println("Radii: " + c1.getRadius() + ", " + c2.getRadius() + ", " + c3.getRadius());
    }
}
