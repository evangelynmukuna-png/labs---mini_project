package ex1;

abstract class Shape {

    abstract double area();    // no body: every concrete subclass MUST implement it
    abstract double perimeter();


    // A concrete method that uses the abstract ones
    void describe() {
        System.out.printf("%-10s area = %7.2f   perimeter = %7.2f%n",
                getClass().getSimpleName(), area(), perimeter());
    }
}

class Circle extends Shape {
    private final double radius;

    Circle(double radius) { this.radius = radius; }

    @Override double area()      { return Math.PI * radius * radius; }
    @Override double perimeter() { return 2 * Math.PI * radius; }
}

class Rectangle extends Shape {
    private final double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override double area()      { return width * height; }
    @Override double perimeter() { return 2 * (width + height); }
}

class Square extends Rectangle {      // a Square IS-A Rectangle with equal sides
    Square(double side) { super(side, side); }
}

public class ShapesDemo {
    public static void main(String[] args) {
        // Shape s = new Shape();         // COMPILE ERROR: Shape is abstract

        Shape[] shapes = { new Circle(4), new Rectangle(5, 8), new Square(8) };
        for (Shape s : shapes) {
            s.describe();
        }
    }
}

