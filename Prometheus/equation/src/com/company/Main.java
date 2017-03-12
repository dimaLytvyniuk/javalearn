package com.company;

public class Main {

    public static void main(String[] args) {
        double a = 3;
        double b = 2.5;
        double c = -0.5;

        //PUT YOUR CODE HERE
        double d = Math.pow(b,2) - 4 * a * c;
        String  x1 ="x1=",
                x2 ="x2=";
        //PUT YOUR CODE HERE
        if (d >= 0)
        {
            x1 += (Math.sqrt(d) - b) / (2 * a);
            x2 += (-Math.sqrt(d) - b) / (2 * a);
        }

        System.out.println(x1);
        System.out.println(x2);

        Matrix();
    }

    public static void  Matrix()
    {
        int size = 8;
        String str[] = {

        };
        for (int i = 0; i < size;i++)
        {
            str ="";
            for (int j = 0; j < size;j++)
                str += "*";

            System.out.println(str);
        }
    }
}
