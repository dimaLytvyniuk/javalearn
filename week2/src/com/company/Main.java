package com.company;

public class Main {

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        for (int i = -10; i < 96;i++)
            System.out.println(fib.getNumber(i));
    }
}
