package ex4;

import java.util.Iterator;
import java.util.NoSuchElementException;

class MyLinkedList<T> implements Iterable<T> {

    // STATIC nested class: a Node does not need the list, so it is not tied to an instance
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) { this.value = value; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int size() { return size; }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    // INNER (non-static) class: it reads the outer list's 'head', so it needs an outer instance
    private class ListIterator implements Iterator<T> {

        private Node<T> current = head;  // 'head' belongs to the outer MyLinkedList

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Evangelyn");
        list.add("Tariro");
        list.add("Faith");

        // Works in a for-each loop because MyLinkedList implements Iterable
        for (String name : list) {
            System.out.println("Visiting: " + name);
        }
        System.out.println("Size = " + list.size());

        // An empty list simply does nothing
        MyLinkedList<Integer> empty = new MyLinkedList<>();
        for (int n : empty) {
            System.out.println("never printed " + n);
        }
        System.out.println("Empty list size = " + empty.size());

        // Two independent iterators over the same list
        Iterator<String> it1 = list.iterator();
        Iterator<String> it2 = list.iterator();
        System.out.println("it1 -> " + it1.next());
        System.out.println("it1 -> " + it1.next());
        System.out.println("it2 -> " + it2.next());   // it2 starts from the beginning
    }
}

