package com.dsalgo.chap03;

import java.util.Scanner;

public class SeqSearchFor {
    static int seqSearch(int[] a, int n, int key) {
        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("要素数：");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("探す値：");
        int key = stdIn.nextInt();

        int idx = seqSearch(x, num, key);

        if (idx == -1) {
            System.out.println("その値の要素は存在しません。");
        } else {
            System.out.println("その値はx[" + idx + "]にあります。");
        }
    }
}
