package com.dsalgo.chap01;

import java.util.Scanner;

public class Min3 {
    static int min3(int a, int b, int c) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int a, b, c;

        System.out.println("三つの整数の最小値を求めます。");
        System.out.print("aの値：");  a = stdIn.nextInt();
        System.out.print("bの値：");  b = stdIn.nextInt();
        System.out.print("cの値：");  c = stdIn.nextInt();

        int min = min3(a, b, c);	// a, b, cの最小値

        System.out.println("最小値は" + min + "です。");
    }
}
