package com.company;

/**
 * Created by dima on 17.03.17.
 */
public class Fibonacci {
    //Повертає число Фібоначчі за номером, нумерація почнеться з одиниці
    //якщо число не можливо вирахувати поверніть -1
    public long getNumber(int position){
        long value = 0;

        if (position <= 0 || position > 92)
            return -1;
        else if (position == 2)
            return 1;
        else if (position == 1)
            return 0;
        else {
            return getNumber(position - 2) + getNumber(position - 1);
        }
    }
}
