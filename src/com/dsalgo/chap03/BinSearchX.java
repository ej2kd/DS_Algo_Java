package com.dsalgo.chap03;

import java.util.Scanner;

public class BinSearchX {
    static int binSearchX(int[] arr, int num, int key) {
        int pl = 0;
        int pr = num - 1;

        do {
            int pc = (pl + pr) / 2;

            if (arr[pc] == key) {
                for (int i = pc; i > 0; i--) {
                    if (arr[i] != key) {
                        return i + 1;
                    }
                }
                return 0;
            } else if (arr[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);

        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("要素数：");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("昇順に入力してください。");

        System.out.print("x[0]: ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);
        }

        System.out.print("探す値：");
        int key = stdIn.nextInt();

        int idx = binSearchX(x, num, key);

        if (idx == -1) {
            System.out.println("その値の要素は存在しません。");
        } else {
            System.out.println("その値はx[" + idx + "]にあります。");
        }
    }
}
