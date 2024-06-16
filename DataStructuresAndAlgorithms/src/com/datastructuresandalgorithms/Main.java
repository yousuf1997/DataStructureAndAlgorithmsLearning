package com.datastructuresandalgorithms;

public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        maxHeap.add(10);
        maxHeap.add(7);
        maxHeap.add(9);
        maxHeap.add(4);
        maxHeap.add(7);
        maxHeap.add(5);
        maxHeap.add(11);
        maxHeap.add(2);
        maxHeap.add(1);
        maxHeap.add(6);

        System.out.println(maxHeap.getMax());

        maxHeap.replace(25, 5);

        System.out.println(maxHeap.getMax());
    }
}
