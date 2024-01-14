package com.datastructuresandalgorithms.queue;

import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> container;
    private int size;

    public Queue() {
        this.container = new LinkedList<>();
        this.size = 0;
    }

    // O(1)
    public void enqueue(T element) {
        this.container.add(element);
        this.size++;
    }

    // O(1)
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        this.size--;
        return this.container.removeFirst();
    }

    // O(1)
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return this.container.getFirst();
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
}
