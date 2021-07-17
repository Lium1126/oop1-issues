package jp.ac.ait.k19061.section09;

import java.util.Random;
import java.util.Scanner;

public class Kadai1 {

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
         * 配列の生成
         */

        // 【エラー処理】int型の整数値に変換可能な文字列が入力されるまで繰り返す
        boolean flag = false;
        System.out.print("生成する配列の大きさを入力してください > ");
        String input;
        do {
            input = sc.nextLine();

            try {
                Integer.parseInt(input);
                flag = true;
            } catch (NumberFormatException nex) {
                System.out.print("整数値として認識できませんでした。再度入力してください > ");
            }
        } while (!flag);

        // ここは例外処理しない(整数値に変換できる文字列しか来ないはず)
        int size = Integer.parseInt(input);
        int[] arr = createRandomIntArray(size);

        // 生成された配列を画面表示
        System.out.print("生成された配列: ");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();

        /*
         * 配列の要素を取り出し
         */

        // 【エラー処理】int型の整数値に変換可能な文字列が入力されるまで繰り返す
        flag = false;
        System.out.print("取り出す配列のインデックスを指定してください > ");
        do {
            input = sc.nextLine();

            try {
                Integer.parseInt(input);
                flag = true;
            } catch (NumberFormatException nex) {
                System.out.print("整数値として認識できませんでした。再度入力してください > ");
            }
        } while (!flag);

        // ここは例外処理しない(整数値に変換できる文字列しか来ないはず)
        int index = Integer.parseInt(input);
        System.out.println("値: " + getValueByIndex(arr, index));
    }

    /**
     * 指定された要素数で各要素がランダムな値を持つ配列を生成して返す
     * @param size 要素数
     * @return 生成されたランダムな値を持つ配列オブジェクト
     */
    public static int[] createRandomIntArray(int size) {

        int[] arr;

        // 【例外処理】配列の要素数として正しくない値が渡された場合の例外を捕捉し、その場合は要素数0の配列を生成する
        if (size < 0) {
            System.out.println("配列の大きさとして適切ではありません");
            arr = new int[0];
        } else {
            arr = new int[size];

            Random random = new Random();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(1000);   // 0〜999まででランダム
            }
        }

        return arr;
    }

    /**
     * 配列とインデックスを渡し、その要素を取り出して返す
     * @param arr 配列のオブジェクト
     * @param index インデックス
     * @return 取り出した要素
     */
    public static int getValueByIndex(int[] arr, int index) {
        // 値が-1と表示されてもそれはよし
        // arr.lengthで要素数を取得できる
        // 【エラー処理】引数arrがnullだった場合、-1を返す
        if (arr == null) {
            // System.out.println("配列が作られていません");
            return -1;
        }
        // 【例外処理】配列のインデックスとして正しくない値が渡された場合の例外を捕捉し、その場合は-1を返す
        if (index < 0 || arr.length <= index) {
            // System.out.println("配列のインデックスとして正しくありません");
            return -1;
        }

        return arr[index];
    }
}
