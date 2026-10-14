package ex3;

import java.util.ArrayList;

class Stack<T> {

    private final ArrayList<T> items = new ArrayList<>();     // hidden storage

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}

public class StackDemo {
    public static void main(String[] args) {

        Stack<String> words = new Stack<>();
        words.push("one");
        words.push("two");
        words.push("three");

        System.out.println("peek -> " + words.peek());
        System.out.println("pop  -> " + words.pop());
        System.out.println("pop  -> " + words.pop());
        System.out.println("isEmpty? " + words.isEmpty());
        System.out.println("pop  -> " + words.pop());
        System.out.println("isEmpty? " + words.isEmpty());

        // The SAME class works for any type
        Stack<Integer> numbers = new Stack<>();
        numbers.push(20);
        numbers.push(30);
        int top = numbers.pop();      // no cast needed: the compiler knows it is Integer
        System.out.println("Integer stack popped: " + top);

        // words.push(5);                         // COMPILE ERROR: Stack<String> only accepts String
        try {
            words.pop();    // already empty
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

