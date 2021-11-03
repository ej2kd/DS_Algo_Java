package com.dsalgo.chap04;

public class IntStack {
    private int[] stk; // 格納する配列
    private int capacity; // スタックの容量
    private int ptr; // スタックポインタ

    //    実行時例外：スタックが空
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    //    実行時例外：スタックが満杯
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    public IntStack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[capacity]; // スタック本体用の配列
        } catch (OutOfMemoryError e) { // スタックの生成に失敗
            capacity = 0;
        }
    }

//    スタックにxをプッシュする
    public int push(int x) throws OverflowIntStackException {
        if (isFull()) { // スタックが満杯である時
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x; // 先にスタックにデータを格納してから、ポインタ値をインクリメントする
    }

//    スタックからデータをポップする
    public int pop() throws EmptyIntStackException {
        if (isEmpty()) { // スタックが空である時
            throw new EmptyIntStackException();
        }
        return stk[--ptr]; // 先にポインタ値をデクリメントしてから、スタックのデータを取り出す
    }

//    スタックからデータをピークする（参照するだけ）
    public int peek() throws EmptyIntStackException {
        if (isEmpty()) { // スタックが空である時
            throw new EmptyIntStackException();
        }
        return stk[ptr - 1];
    }

//    スタックを空にする
    public void clear() {
        ptr = 0;
    }

//    スタックからxを探す
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--) { // From top to bottom
            if (stk[i] == x) {
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
