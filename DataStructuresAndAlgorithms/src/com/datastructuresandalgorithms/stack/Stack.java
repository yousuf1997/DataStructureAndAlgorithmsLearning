package com.datastructuresandalgorithms.stack;

import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> container;
    private int size;

    public Stack() {
        this.container = new LinkedList<>();
        this.size = 0;
    }

    // O(1)
    public void push(T element) {
        this.container.add(element);
        this.size++;
    }

    // O(1)
    public T pop() {
        if (size == 0) {
            // empty;
            return null;
        }
        this.size--;
        return this.container.removeLast();
    }

    // O(1)
    public T peek() {
        if (size == 0) {
            // empty;
            return null;
        }
        return this.container.getLast();
    }

    // O(1)
    public int size() {
        return this.size;
    }

    // O(1)
    public boolean isEmpty() {
        return this.size == 0;
    }
}
