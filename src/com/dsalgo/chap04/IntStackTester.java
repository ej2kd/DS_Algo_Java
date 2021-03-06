package com.dsalgo.chap04;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while (true) {
            System.out.printf("現在のデータ数：%d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1)プッシュ (2)ポップ (3)ピーク (4)ダンプ (5)クリア (6)探索 (0)終了：");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("データ：");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("スタックが満杯です。");
                    }
                    break;
                case 2:
                    try {
                        x = s.pop();
                        System.out.println("ポップしたデータは" + x + "です。");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("スタックが空です。");
                    }
                    break;
                case 3:
                    try {
                        x = s.peek();
                        System.out.println("ピークしたデータは" + x + "です。");
                    } catch (IntStack.EmptyIntStackException e) {
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
                    System.out.print("探索する値を入力: ");
                    x = stdIn.nextInt();
                    int result = s.indexOf(x);
                    if (result >= 0) {
                        System.out.printf("%dは%dにあります。", x, result);
                    } else {
                        System.out.printf("%dは見つかりませんでした。", x);
                    }
                    System.out.println();
                    break;
            }
        }
    }
}
