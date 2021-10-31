package com.dsalgo.chap01;

import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int n = stdIn.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
