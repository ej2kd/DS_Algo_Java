package com.dsalgo.chap04;

import java.util.Scanner;

public class StackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Stack<String> s = new Stack<String>(64);

        while (true) {
            System.out.printf("現在のデータ数：%d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1)プッシュ (2)ポップ (3)ピーク (4)ダンプ (5)クリア (6)探索 (0)終了：");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            String x;
            switch (menu) {
                case 1:
                    System.out.print("データ：");
                    x = stdIn.next();
                    try {
                        s.push(x);
                    } catch (Stack.OverflowGStackException e) {
                        System.out.println("スタックが満杯です。");
                    }
                    break;
                case 2:
                    try {
                        x = s.pop();
                        System.out.println("ポップしたデータは" + x + "です。");
                    } catch (Stack.EmptyGStackException e) {
                        System.out.println("スタックが空です。");
                    }
                    break;
                case 3:
                    try {
                        x = s.peek();
                        System.out.println("ピークしたデータは" + x + "です。");
                    } catch (Stack.EmptyGStackException e) {
                        System.out.println("スタックが空です。");
                    }
                    break;
                case 4:
                    s.dump();
                    break;
                case 5:
                    s.clear();
                    System.out.println("スタックの中身を消去しました。");
                    break;
                case 6:
                    System.out.print("探索する要素を入力: ");
                    String word = stdIn.next();
                    int result = s.indexOf(word);
                    if (result >= 0) {
                        System.out.printf("%sは%dにあります。", word, result);
                    } else {
                        System.out.printf("%sは見つかりませんでした。", word);
                    }
                    System.out.println();
                    break;
            }
        }
    }
}

