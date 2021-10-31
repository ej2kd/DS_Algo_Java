package com.dsalgo.chap03;

public class ChainHash<K,V> {
    class Node<K, V> {
        private K key; // Key value
        private V data; // Data value
        private Node<K, V> next; // pointer

        Node(K key, V data, Node<K, V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        public int hashCode() {
            return key.hashCode();
        }
    }

    private int size; // ハッシュ表の大きさ
    private Node<K, V>[] table; // ハッシュ表

    public ChainHash(int capacity) {
        try {
            table = new Node[capacity];
            this.size = capacity;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

//    ハッシュ値を求める
    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

//    キー値がkeyである要素の探索（データの返却）
    public V search(K key) {
        int hash = hashValue(key); // 探索データのハッシュ値
        Node<K, V> p = table[hash]; // 着目するノード

        while (p != null) {
            if (p.getKey().equals(key)) {
                return p.getValue();
            }
            p = p.next;
        }
        return null;
    }

//      キーの値がkey、データ値がdataの要素を追加する
    public int add(K key, V data) {
        int hash = hashValue(key); // 追加するノードのハッシュ値
        Node<K, V> p = table[hash]; // 着目するノード

        while (p != null) {
            if (p.getKey().equals(key)) {
                return 1; // このキー値は登録済み
            }
            p = p.next; // 後続ノードへ移動
        }
        Node<K, V> temp = new Node<K, V>(key, data, table[hash]);
        table[hash] = temp; // ノードの挿入
        return 0;
    }

//    キー値がkeyである要素の削除
    public int remove(K key) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash]; // 着目ノード
        Node<K, V> pp = null; // 前回の着目ノード

        while (p != null) {
            if (p.getKey().equals(key)) {
                if (pp == null) {
                    table[hash] = p.next;
                } else {
                    pp.next = p.next;
                }
                return 0;
            }
            pp = p;
            p = p.next; // 後続ノードへ移動
        }
        return 1; // キー値が存在しない
    }

//    ハッシュ表をダンプ
    public void dump() {
        for (int i = 0; i < size; i++) {
            Node<K, V> p = table[i];
            System.out.printf("%02d ", i);
            while (p != null) {
                System.out.printf("-> %s (%s) ", p.getKey(), p.getValue());
                p = p.next;
            }
            System.out.println();
        }
    }
}
