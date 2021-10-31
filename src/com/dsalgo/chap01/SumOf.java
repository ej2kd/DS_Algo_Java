package com.dsalgo.chap01;

import java.util.Scanner;

public class SumOf {
    static int sumof(int a, int b) {
        int start, end;
        if (a >= b) {
            start = b;
            end = a;
        } else {
            start = a;
            end = b;
        }

        return ((end - start + 1) * (start + end)) / 2;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("aからbまでの総和を計算します。");
        System.out.print("aの値を入力：");
        int a = stdIn.nextInt();
        System.out.print("bの値を入力：");
        int b = stdIn.nextInt();

        int sum = sumof(a, b);

        System.out.println(a + "から" + b + "までの総和は" + sum + "です。");
    }
}
