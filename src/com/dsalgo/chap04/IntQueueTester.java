package com.dsalgo.chap04;

import java.util.Scanner;

public class IntQueueTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntQueue q = new IntQueue(64);

        while (true) {
            System.out.printf("現在のデータ数：%d / %d\n", q.size(), q.getCapacity());
            System.out.print("(1)エンキュー (2)デキュー (3)ピーク " +
                    "(4)ダンプ (5)探索 (0)終了: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("データ：");
                    x = stdIn.nextInt();
                    try {
                        q.enque(x);
                    } catch (IntQueue.OverflowIntQueueException e) {
                        System.out.println("キューが満杯です。");
                    }
                    break;
                case 2:
                    try {
                        x = q.deque();
                        System.out.println("デキューしたデータは" + x + "です。");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("キューは空です。");
                    }
                    break;
                case 3:
                    try {
                        x = q.peek();
                        System.out.println("ピークしたデータは" + x + "です。");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("キューは空です。");
                    }
                    break;
                case 4:
                    q.dump();
                    break;
                case 5:
                    System.out.print("探索データ：");
                    x = stdIn.nextInt();
                    int result = q.search(x);
                    if (result == 0) {
                        System.out.println("対象データは見つかりませんでした。");
                    } else {
                        System.out.printf("%dは%d番目にあります。", x, result);
                    }
            }
        }
    }
}
