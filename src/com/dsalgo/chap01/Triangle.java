package com.dsalgo.chap01;

import java.util.Scanner;

public class Triangle {
    static void triangleLB(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int n = stdIn.nextInt();

        triangleLB(n);
    }
}
