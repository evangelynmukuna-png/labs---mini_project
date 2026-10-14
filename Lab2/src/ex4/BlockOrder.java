package ex4;

public class BlockOrder {
    static { System.out.println("Static block 1"); }

    {System.out.println("Instance block 1"); }

    static { System.out.println("Static block 2"); }

    {System.out.println("Instance block 2"); }

    BlockOrder() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        System.out.println("main starts");
        System.out.println("--- first object ---");
        new BlockOrder();
        System.out.println("--- second object ---");
        new BlockOrder();
    }
}
