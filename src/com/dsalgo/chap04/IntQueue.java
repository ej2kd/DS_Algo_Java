package com.dsalgo.chap04;

// 論理的な先頭、末尾の概念を導入し、デキューによる要素の移動をなくす：O(n) -> O(1)
public class IntQueue {
    private int[] que;
    private int capacity;
    private int front; // 論理的先頭
    private int rear; // 論理的末尾
    private int num;

    //    実行時例外：キューが空
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() { }
    }

    //    実行時例外：キューが満杯
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() { }
    }

    public IntQueue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int enque(int x) throws OverflowIntQueueException {
        if (isFull()) {
            throw new OverflowIntQueueException();
        }
        que[rear++] = x;
        num++;

        if (rear == capacity) {
            rear = 0;
        }
        return x;
    }

    public int deque() throws EmptyIntQueueException {
        if (isEmpty()) {
            throw new EmptyIntQueueException();
        }

        int x = que[front++];
        num--;
        if (front == capacity) {
            front = 0;
        }
        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (isEmpty()) {
            throw new EmptyIntQueueException();
        }
        return que[front];
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % capacity;
            if (que[idx] == x) {
                return idx;
            }
        }
        return -1;
    }

    public int search(int x) {
        for (int i = 0; i < num; i++) {
            if (que[(i + front) % capacity] == x) {
                return i + 1;
            }
        }
        return 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return num;
    }

    public boolean isFull() {
        return num >= capacity;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public void dump() {
        if (isEmpty()) {
            System.out.println("キューは空です。");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.print(que[(i + front) % capacity] + " ");
            }
            System.out.println();
        }
    }
}
