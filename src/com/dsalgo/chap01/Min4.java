package com.dsalgo.chap01;

import java.util.Scanner;

public class Min4 {
    static int min4(int a, int b, int c, int d) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;
        return min;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int a, b, c, d;
        System.out.println("4つの値の最小値を求めます。");
        System.out.print("aの値:"); a = stdIn.nextInt();
        System.out.print("bの値:"); b = stdIn.nextInt();
        System.out.print("cの値:"); c = stdIn.nextInt();
        System.out.print("dの値:"); d = stdIn.nextInt();

        int min = min4(a, b, c, d);

        System.out.println("最小値は" + min + "です。");
    }
}
