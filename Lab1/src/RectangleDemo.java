public class RectangleDemo {
    public static void main(String[] args) {
        Rectangle[] rects = {
                new Rectangle(3, 8), new Rectangle(12, 9), new Rectangle(2, 1), new Rectangle(7, 3), new Rectangle(1,1)
        };
        Rectangle largest = rects[0];
        for (Rectangle r : rects) {
            if(r.area() > largest.area()) largest = r;
        }
        System.out.println("Largest: " + largest.width + " x " + largest.height + ", area = " + largest.area());
    }
}
