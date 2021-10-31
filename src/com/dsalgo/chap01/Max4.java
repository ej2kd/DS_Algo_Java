package com.dsalgo.chap01;

public class Max4 {
    static int max4(int a, int b, int c, int d) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        return max;
    }

    public static void main(String[] args) {
        System.out.println("max4(4,3,2,1) = " + max4(4, 3, 2, 1));
        System.out.println("max4(3,3,2,4) = " + max4(3, 3, 2, 4));
        System.out.println("max4(432,910,754,2) = " + max4(432, 910, 754, 2));
        System.out.println("max4(432,542,9999,2) = " + max4(432, 542, 9999, 2));
    }
}
