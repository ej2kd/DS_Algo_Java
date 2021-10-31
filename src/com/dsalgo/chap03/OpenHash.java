package com.dsalgo.chap03;

public class OpenHash<K, V> {
//    バケットの状態
    enum Status {OCCUPIED, EMPTY, DELETED};

//    バケット
    static class Bucket<K, V> {
        private K key;
        private V data;
        private Status stat;

//        Constructor

        Bucket() {
            stat = Status.EMPTY; // 初期状態ではバケットは空
        }

//        全フィールドに値を設定
        void set(K key, V data, Status stat) {
            this.key = key;
            this.data = data;
            this.stat = stat;
        }

        public void setStat(Status stat) {
            this.stat = stat;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return data;
        }

//        キーのハッシュ値を返す
        public int hashCode() {
            return key.hashCode();
        }
    }

    private int size; // ハッシュ表の大きさ
    private Bucket<K, V>[] table; // ハッシュ表

//    Constructor
    public OpenHash(int size) {
        try {
            table = new Bucket[size];
            for (int i = 0; i < size; i++) {
                table[i] = new Bucket<K, V>();
            }
            this.size = size;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

//    ハッシュ値の算出
    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

//    再ハッシュ値を求める
    public int rehashValue(int hash) {
        return (hash + 1) % size;
    }

//    キー値がkeyであるバケットの探索
    private Bucket<K, V> searchNode(K key) {
        int hash = hashValue(key); // 探索データのハッシュ値
        Bucket<K, V> p = table[hash]; // 着目するバケット

        for (int i = 0; p.stat != Status.EMPTY && i < size; i++) {
            if (p.stat == Status.OCCUPIED && p.getKey().equals(key)) {
                return p;
            }
            hash = rehashValue(hash); // 再ハッシュ
            p = table[hash];
        }
        return null;
    }

//    キー値がkeyである要素の探索（データ返却）
    public V search(K key) {
        Bucket<K, V> p = searchNode(key);
        if (p != null) {
            return p.getValue();
        } else {
            return null;
        }
    }

//    キー値がkey、データ値がdataである要素の追加
    public int add(K key, V data) {
        if (search(key) != null) {
            return 1; // このキー値は登録済み
        }

        int hash = hashValue(key);
        Bucket<K, V> p = table[hash];
        for (int i = 0; i < size; i++) {
            if (p.stat == Status.EMPTY || p.stat == Status.DELETED) {
                p.set(key, data, Status.OCCUPIED);
                return 0;
            }
            hash = rehashValue(hash);
            p = table[hash];
        }
        return 2; // ハッシュ表が満杯
    }

//    キー値がkeyである要素の削除
    public int remove(K key) {
        Bucket<K, V> p = searchNode(key);
        if (p == null) {
            return 1; // このキー値は登録されていない
        }

        p.setStat(Status.DELETED);
        return 0;
    }

//    ハッシュ表をダンプ
    public void dump() {
        for (int i = 0; i < size; i++) {
            System.out.printf("%02d ", i);
            switch (table[i].stat) {
                case OCCUPIED:
                    System.out.printf("%s (%s)\n",
                            table[i].getKey(), table[i].getValue());
                    break;
                case EMPTY:
                    System.out.println("---未登録---");
                    break;
                case DELETED:
                    System.out.println("---削除ずみ---");
                    break;
            }
        }
    }
}
