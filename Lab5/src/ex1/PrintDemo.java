package ex1;

import java.util.Arrays;

public class PrintDemo {

    // Same name, different parameter lists: the COMPILER picks one from the argument type
    void print(int value) {
        System.out.println("int: " + value);
    }

    void print(double value) {
        System.out.println("double: " + value);
    }

    void print(String value) {
        System.out.println("String: " + value);
    }

    void print(int[] values) {
        System.out.println("int[]: " + Arrays.toString(values));
    }

    public static void main(String[] args) {
        PrintDemo p = new PrintDemo();

        p.print(85);                           // print (int)
        p.print(5.75);                         // print (double)
        p.print("Hello");                      // print (String)
        p.print(new int[]{1, 2, 3});           // print (int[])
        p.print(2.5f);                         // float has no exact match, widens to double
        p.print('A');                          // char widens to int, so prints 65
    }

}
