package ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Enter the first integer:");
            int a = in.nextInt();      // throws InputMismatchException if not a number

            System.out.println("Enter the second integer:");
            int b = in.nextInt();

            int result = a / b;           // throws ArithmeticException if b is 0
            System.out.println(a + " / " + b + " = " + result);

        } catch (InputMismatchException e) {
            System.out.println("Error: please type whole numbers only.");

        } catch (ArithmeticException e) {
            System.out.println("Error: you cannot divide by zero.");

        } finally {
            in.close();            // always runs               // always runs
            System.out.println("Program finished.");
        }
    }
}
