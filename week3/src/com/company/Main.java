package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = {1,5,2,4,10,6,0,3,10};

        for (int i = 0, size = array.length / 2, n = array.length - 1; i < size;i++)
        {
            int prom = array[i];
            array[i] = array[n - i];
            array[n - i] = prom;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
