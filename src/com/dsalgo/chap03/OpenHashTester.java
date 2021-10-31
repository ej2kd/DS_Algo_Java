package com.dsalgo.chap03;

import java.util.Scanner;

public class OpenHashTester {
    static Scanner stdIn = new Scanner(System.in);

//    データ（会員番号＋氏名）
    static class Data {
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no;
        private String name;

//        キー値
        Integer keyCode() {
            return no;
        }

//        文字列表現の返却
        public String toString() {
            return name;
        }

        void scanData(String guide, int sw) {
            System.out.println(guide + "するデータを入力してください。");

            if ((sw & NO) == NO) {
                System.out.print("番号：");
                no = stdIn.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.print("氏名：");
                name = stdIn.next();
            }
        }
    }

    enum Menu {
        ADD("追加"),
        REMOVE("削除"),
        SEARCH("探索"),
        DUMP("表示"),
        TERMINATE("終了");

        private final String message;

        static Menu MenuAt(int idx) {
            for (Menu m : Menu.values()) {
                if (m.ordinal() == idx) {
                    return m;
                }
            }
            return null;
        }

        Menu (String string) {
            message = string;
        }

        String getMessage() {
            return message;
        }
    }

    static Menu selectMenu() {
        int key;
        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s ", m.ordinal(), m.getMessage());
            }
            System.out.print("：");
            key = stdIn.nextInt();
        } while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu; // メニュー
        Data data; // 追加用データ参照
        Data temp = new Data(); // 読み込み用データ

        OpenHash<Integer, Data> hash = new OpenHash<Integer, Data>(13);
        do {
            switch (menu = selectMenu()) {
                case ADD:
                    data = new Data();
                    data.scanData("追加", Data.NO | Data.NAME);
                    int k = hash.add(data.keyCode(), data);
                    switch (k) {
                        case 1:
                            System.out.println("そのキー値は登録済みです。");
                            break;
                        case 2:
                            System.out.println("ハッシュ表が満杯です。");
                            break;
                    }
                    break;
                case REMOVE:
                    temp.scanData("削除", Data.NO);
                    hash.remove(temp.keyCode());
                    break;
                case SEARCH:
                    temp.scanData("探索", Data.NO);
                    Data t = hash.search(temp.keyCode());
                    if (t != null) {
                        System.out.println("そのキー値を持つデータは" + t + "です。");
                    } else {
                        System.out.println("該当するデータはありません。");
                    }
                    break;
                case DUMP:
                    hash.dump();
                    break;
            }
        } while (menu != Menu.TERMINATE);
    }
}
