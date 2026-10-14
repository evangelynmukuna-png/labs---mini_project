package ex2;

public class ArrayDemo {

    // Returns the element at the index, or -1 if the index is invalid
    static int getElement(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index " + index + ": " + e.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};

        System.out.println("Element at 1 = " + getElement(numbers, 1));
        System.out.println("Element at 5 = " + getElement(numbers, 5));
        System.out.println("Element at -1 = " + getElement(numbers, -1));
    }
}

