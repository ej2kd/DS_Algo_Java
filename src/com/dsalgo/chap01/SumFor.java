package com.dsalgo.chap01;

import java.util.Scanner;

public class SumFor {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("1からnまでの総和を計算します。");
        System.out.print("nの値を入力：");
        int n = stdIn.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println("1から" + n + "までの総和は" + sum + "です。");
    }
}
