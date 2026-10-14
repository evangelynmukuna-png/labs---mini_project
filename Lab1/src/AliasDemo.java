public class AliasDemo {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(7, 8);
        Rectangle r2 = r1;
        r2.width = 9;
        System.out.println("r1.width = " + r1.width);
    }
}
