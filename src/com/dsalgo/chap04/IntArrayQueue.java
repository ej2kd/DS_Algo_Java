package com.dsalgo.chap04;

public class IntArrayQueue {
    private int[] que; // キューを格納する配列
    private int capacity; // キューの容量
    private int num; // 現在のデータ数

    //    実行時例外：キューが空
    public class EmptyIntArrayQueueException extends RuntimeException {
        public EmptyIntArrayQueueException() { }
    }

    //    実行時例外：キューが満杯
    public class OverflowIntArrayQueueException extends RuntimeException {
        public OverflowIntArrayQueueException() { }
    }

    public IntArrayQueue(int maxlen) {
        capacity = maxlen;
        num = 0;
        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int enque(int x) throws OverflowIntArrayQueueException {
        if (isFull()) {
            throw new OverflowIntArrayQueueException();
        }
        que[num++] = x;
        return x;
    }

    public int deque() throws EmptyIntArrayQueueException {
        if (isEmpty()) {
            throw new EmptyIntArrayQueueException();
        }
        int x = que[0]; // 列の先頭を取り出す
        for (int i = 0; i < num - 1; i++) {
            que[i] = que[i + 1]; // 取り出した後の要素を前方にシフトする: O(n)
        }
        num--;
        return x;
    }

    public int peek() throws EmptyIntArrayQueueException {
        if (isEmpty()) {
            throw new EmptyIntArrayQueueException();
        }
        return que[0]; // 先頭の値を返す
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            if (que[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        num = 0;
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= capacity;
    }

    public void dump() {
        if (isEmpty()) {
            System.out.println("キューは空です。");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.print(que[i] + " ");
            }
            System.out.println();
        }
    }
}
