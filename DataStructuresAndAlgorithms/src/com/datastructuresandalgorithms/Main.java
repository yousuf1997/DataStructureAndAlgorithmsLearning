package com.datastructuresandalgorithms;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();


        List<Integer> mutableList = new ArrayList<>();

        // Adding 13 numbers to the list
        mutableList.add(1);
        mutableList.add(6);
        mutableList.add(9);
        mutableList.add(2);
        mutableList.add(7);
        mutableList.add(5);
        mutableList.add(7);
        mutableList.add(4);
        mutableList.add(10);

        maxHeap.heapSort(mutableList);

        mutableList.forEach(integer -> System.out.println(integer));
    }
}
