/**
 * オブジェクト指向プログラミング
 * 第7回
 * 課題1-クラス
 * フィボナッチ数列を格納したList<Integer>を返すプログラムを作成せよ
 */

package jp.ac.ait.oop1.k19061;

import java.util.*;

public class Fibonacci implements IKadai07_1 {

    @Override
    public List<Integer> get(int max_value) {

        int n1 = 0;  //---+
        int n2 = 1;  //---+--基底
        int f = 0;

        List<Integer> ret = new ArrayList<>(); // フィボナッチ数列を格納するリスト

        // 基底を追加しておく
        if (max_value >= 0) ret.add(n1);
        if (max_value >= 1) ret.add(n2);

        //算出される値nが引数の値以下の間繰り返す
        while ((n1 + n2) <= max_value) {
            f = n1 + n2;
            ret.add(f);         //計算結果を追加
            n1 = n2;            //次の計算値1に今の計算値2を代入
            n2 = f;             //次の計算値2に算出結果を代入
        }

        return ret;
    }

    public static void main(String[] args) {

        Fibonacci app = new Fibonacci();
        System.out.println("   -1 : " + app.get(-1));        // [] : 空配列
        System.out.println("    0 : " + app.get(0));         // [0] : 0のみ
        System.out.println("    1 : " + app.get(1));         // [0,1,1] : 1が2つ格納されることに注意
        System.out.println("    2 : " + app.get(2));         // [0,1,1,2] : 最初の方に基底以外の数を代入する処理が正しく行われているか
        System.out.println("10000 : " + app.get(10000));     // [0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765]

        /*---以降、対話型の動作確認---*/
        Scanner sc = new Scanner(System.in);
        int n = 0;    // 入力値

        do {
            // ユーザにメッセージを出力
            System.out.println("\n整数を入力してください");
            System.out.println("負の数を入力すると終了します");

            String input = sc.nextLine();
            try {
                n = Integer.parseInt(input);
                if (n >= 0) {
                    System.out.println(n + " : " + app.get(n));
                }
            } catch (Exception e) {
                System.out.println("入力が不正です");
                n = 1;
            }
        } while(n >= 0);

        sc.close();
    }
}
