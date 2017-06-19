package com.company;

/**
 * Created by dima on 27.03.17.
 */
public class Demo {
    public void make() {
        Enum enu = D.B;
    }
}

enum D {
    A, B, C;

    private D() {
        System.out.println("*");
    }
}
