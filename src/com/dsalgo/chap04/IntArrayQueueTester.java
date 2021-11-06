package com.dsalgo.chap04;

import java.util.Scanner;

public class IntArrayQueueTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntArrayQueue q = new IntArrayQueue(64);

        while (true) {
            System.out.println("現在のデータ数：" + q.size() + " / " + q.capacity());
            System.out.print("(1)エンキュー (2)デキュー (3)ピーク" +
                    " (4)ダンプ (0)終了: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x = 0;
            switch (menu) {
                case 1:
                    System.out.print("データ：");
                    x = stdIn.nextInt();
                    try {
                        q.enque(x);
                    } catch (IntArrayQueue.OverflowIntArrayQueueException e) {
                        System.out.println("キューが満杯です。");
                    }
                    break;
                case 2:
                    try {
                        x = q.deque();
                        System.out.println("デキューした値は" + x + "です。");
                    } catch (IntArrayQueue.EmptyIntArrayQueueException e) {
                        System.out.println("キューが空です。");
                    }
                    break;
                case 3:
                    try {
                        x = q.peek();
                        System.out.println("ピークした値は" + x + "です。");
                    } catch (IntArrayQueue.EmptyIntArrayQueueException e) {
                        System.out.println("キューが空です。");
                    }
                    break;
                case 4:
                    q.dump();
                    break;
            }
        }
    }
}
