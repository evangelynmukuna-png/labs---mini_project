package ex5;

import java.util.ArrayList;

// BAD DESIGN: a Stack that IS-A ArrayList (inheritance)
class StackByInheritance<T> extends ArrayList<T> {

    public void push(T item) { add(item); }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return remove(size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return get(size() - 1);
    }
}

// GOOD DESIGN: a Stack that HAS-A ArrayList (composition)
class Stack<T> {

    private final ArrayList<T> items = new ArrayList<>();            // hidden implementation detail
    public void push(T item) { items.add(item); }

    public T pop() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() { return items.isEmpty(); }
    public int size()        { return items.size(); }

    @Override
    public String toString() { return items.toString(); }
}

public class StackDemo {
    public static void main(String[] args) {

        System.out.println("=== Inheritance version ===");
        StackByInheritance<String> bad = new StackByInheritance<>();
        bad.push("A");
        bad.push("B");
        bad.push("C");
        System.out.println("Stack: " + bad);

        // These all COMPILE, but they break the rule "only touch the top":
        bad.add(0, "X");           // insert at the BOTTOM
        bad.remove(1);             // remove from the MIDDLE
        System.out.println("After illegal changes: " + bad);
        System.out.println("get(0) peeks at the bottom: " + bad.get(0));

        System.out.println();
        System.out.println("=== Composition version ===");
        Stack<String> good = new Stack<>();
        good.push("A");
        good.push("B");
        good.push("C");
        System.out.println("Stack: " + good);
        System.out.println("pop()  -> " + good.pop());
        System.out.println("peek() -> " + good.peek());
        System.out.println("size   -> " + good.size());

        // good.add(0, "X");             // COMPILE ERROR: no such method
        // good.remove(1);               // COMPILE ERROR: no such method
        // good.get(0);                  // COMPILE ERROR: no such method
    }
}
