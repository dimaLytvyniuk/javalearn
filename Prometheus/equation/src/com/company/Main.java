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

        //System.out.println(x1);
        //System.out.println(x2);

        //Matrix();
        //sortBubble();
        //Shellsort();

        int data[] = { 2, 18, 20, 25, 38, 41, 43, 66, 73, 92};
        int numberToFind = 101;

        System.out.println(SearhBinary(data,0,data.length - 1git,numberToFind));
    }

    public static void  Matrix()
    {
        int size = 5;

        for (int i = 0,count = size - 1; i < size;i++)
        {
            for (int j = 0; j < size;j++)
            {
                if (j == i || j == count - i)
                    System.out.print(" * ");
                else
                    System.out.print(String.format("%1$2d ",i * size + j + 1));
            }

            System.out.println();
        }
    }

    public static void sortBubble()
    {
        int[] array = {-11111, 4, 3, 2, 11111, 1};
        int length = array.length;

        //PUT YOUR CODE HERE
        for (int i = 0; i < length ;i++)
        {
            boolean swap = false;

            for (int j = 0; j < length - i - 1;j++)
            {
                if (array[j] > array[j + 1])
                {
                    int prom = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = prom;
                    swap = true;
                }
            }

            if (!swap)
                break;
        }


        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void Shellsort()
    {
        int[] array = {30, 2, 10, 4, 6};
        int length = array.length;

        for(int k = length/2; k > 0; k /= 2)
            for(int i = k; i < length; i += 1)
            {
                int t = array[i];
                int j;
                for(j = i; j >= k; j -= k)
                {
                    if(t < array[j-k])
                        array[j] = array[j-k];
                    else
                        break;
                }
                array[j] = t;
            }

        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int SearhBinary(int[] data,int start,int end,int value) {

        if (end < start)
            return -1;

        int koef = (end + start) / 2;

        if (data[koef] > value)
            return SearhBinary(data,start,koef - 1,value);
        else if (data[koef] < value)
            return SearhBinary(data,koef + 1,end,value);
        else
            return koef;
    }
}
