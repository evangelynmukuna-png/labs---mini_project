package ex5;

import java.util.Arrays;

public class SortDemo {

    // T must be a reference type that can compare itself to another T
    static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int pass = 0; pass < arr.length - 1; pass++) {
            boolean swapped = false;
            for (int i = 0; i < arr.length - 1 - pass; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {         // arr[i] is bigger: swap
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;                        // already sorted: stop early
            }
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {100, 29, 15, 10, 76, 5};
        String[] names = {"Evangelyn", "Tariro", "Faith", "Merit", "Kyla"};

        System.out.println("Before: " + Arrays.toString(numbers));
        bubbleSort(numbers);
        System.out.println("After : " + Arrays.toString(numbers));

        System.out.println("Before: " + Arrays.toString(names));
        bubbleSort(names);
        System.out.println("After : " + Arrays.toString(names));

        // int[] primitives = {5, 2, 9};
        // bubbleSort(primitives);        // COMPILE ERROR: int[] is not a T[] (see explanation)

    }
}

