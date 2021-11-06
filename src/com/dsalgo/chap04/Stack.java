package com.dsalgo.chap04;

import java.util.EmptyStackException;

// Generic Stackの実装
public class Stack<E> {
    private E[] stk;
    private int capacity;
    private int ptr;

    //    実行時例外：スタックが空
    public static class EmptyGStackException extends RuntimeException {
        public EmptyGStackException() { }
    }

    //    実行時例外：スタックが満杯
    public static class OverflowGStackException extends RuntimeException {
        public OverflowGStackException() { }
    }

    public Stack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = (E[]) new Object[capacity]; // スタック本体用の配列
        } catch (OutOfMemoryError e) { // スタックの生成に失敗
            capacity = 0;
        }
    }

    //    スタックにobjをプッシュする
    public E push(E obj) throws OverflowGStackException {
        if (isFull()) { // スタックが満杯である時
            throw new OverflowGStackException();
        }
        return stk[ptr++] = obj; // 先にスタックにデータを格納してから、ポインタ値をインクリメントする
    }

    //    スタックからデータをポップする
    public E pop() throws EmptyGStackException {
        if (isEmpty()) { // スタックが空である時
            throw new EmptyGStackException();
        }
        return stk[--ptr]; // 先にポインタ値をデクリメントしてから、スタックのデータを取り出す
    }

    //    スタックからデータをピークする（参照するだけ）
    public E peek() throws EmptyGStackException {
        if (isEmpty()) { // スタックが空である時
            throw new EmptyGStackException();
        }
        return stk[ptr - 1];
    }

    //    スタックを空にする
    public void clear() {
        ptr = 0;
    }

    //    スタックからxを探す
    public int indexOf(E x) {
        for (int i = ptr - 1; i >= 0; i--) { // From top to bottom
            if (stk[i].equals(x)) {
                return i; // Success
            }
        }
        return -1; // Fail
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= capacity;
    }

    public void dump() {
        if (isEmpty()) {
            System.out.println("スタックは空です。");
        } else {
            for (int i = 0; i < ptr; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }
}
