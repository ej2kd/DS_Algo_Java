package com.dsalgo.chap01;

import java.util.Scanner;

public class SumWhile {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("1からnまでの総和を計算します。");
        System.out.print("nの値を入力：");
        int n = stdIn.nextInt();

        int sum = 0;
        int i = 1;

        while (i <= n) {
            sum += i;
            i++;
        }
        System.out.println("iの値は" + i + "です。");
        System.out.println("1から" + n + "までの総和は" + sum + "です。");
    }
}
