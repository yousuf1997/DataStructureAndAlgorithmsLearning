package com.datastructuresandalgorithms.main;

import com.datastructuresandalgorithms.stack.Stack;

public class Main {

    public static void main(String[] args) {
        // Stack example
        Stack<String> names = new Stack<>();

        names.push("Amir");
        names.push("Jackob");
        names.push("John");
        names.push("Kevin");

        System.out.println("Top element >> " + names.peek());
        System.out.println("Remove top element >> " + names.pop());
        System.out.println("Top element >> " + names.peek());

    }
}
