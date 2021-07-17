/**
 * オブジェクト指向プログラミング
 * 第7回
 * 課題2-クラス
 * 数値コレクション(List<Integer>)をFizzBuzz変換したリストList<String>
 * を返すプログラムを作成せよ
 */

package jp.ac.ait.oop1.k19061;

import java.util.*;

public class FizzBuzz implements IKadai07_2{
    @Override
    public List<String> getConverted(List<Integer> targetList) {

        List<String> ret = new ArrayList<>();

        for (int val : targetList) {
            if (val % 15 == 0) {
                ret.add("FizzBuzz");
            } else if (val % 3 == 0) {
                ret.add("Fizz");
            } else if (val % 5 == 0) {
                ret.add("Buzz");
            } else {
                ret.add(String.valueOf(val));
            }
        }

        return ret;
    }

    public static void main(String[] args) {

        Integer[] a1 = {1, 2, 3, 4, 5};            // "Fizz"と"Buzz"が含まれているケース
        Integer[] a2 = {1, 2, 4};                  // FizzBuzz変換されるものがないケース(String型の要素が返されているかは要確認)
        Integer[] a3 = {12, 13, 14, 15, 16};       // "FizzBuzz"が含まれているケース
        Integer[] a4 = {3, 30, 300};               // "Fizz"と"FizzBuzz"が含まれているケース
        Integer[] a5 = {};                         // 空リストが返ってくるか確認するケース
        Integer[] a6 = {-1, -2, -3, -4, -5, -15};  // 負の数で、かつ"Fizz","Buzz","FizzBuzz"が含まれているケース

        FizzBuzz app = new FizzBuzz();
        List<Integer> a = new ArrayList<>(Arrays.asList(a1));
        System.out.println(a + " -> " + app.getConverted(a));  // [1,2,3,4,5] → ["1", "2", "Fizz", "4", "Buzz"]

        List<Integer> b = new ArrayList<>(Arrays.asList(a2));
        System.out.println(b + " -> " + app.getConverted(b));  // [1,2,4] → ["1", "2", "4"]
        // 要素がString型である事の確認
        for (String element : app.getConverted(b)) {
            System.out.print(element);
            if (element instanceof String) System.out.println("はStringクラスです");
            else System.out.println("はStringクラスではありません");
        }

        List<Integer> c = new ArrayList<>(Arrays.asList(a3));
        System.out.println(c + " -> " + app.getConverted(c));  // [12,13,14,15,16] → ["Fizz", "13", "14", "FizzBuzz", "16"]

        List<Integer> d = new ArrayList<>(Arrays.asList(a4));
        System.out.println(d + " -> " + app.getConverted(d));  // [3,30,300] → ["Fizz", "FizzBuzz", "FizzBuzz"]

        List<Integer> e = new ArrayList<>(Arrays.asList(a5));
        System.out.println(e + " -> " + app.getConverted(e));  // [] → []

        List<Integer> f = new ArrayList<>(Arrays.asList(a6));
        System.out.println(f + " -> " + app.getConverted(f));  // [-1,-2,-3,-4,-5,-15] → ["-1", "-2", "Fizz", "-4", "Buzz", "FizzBuzz"]

        /*---以降、対話型の動作確認---*/
        Scanner sc = new Scanner(System.in);
        int array_num = 0;  // 入力値

        do {
            // ユーザにメッセージを表示
            System.out.println("\n要素数を入力してください");
            System.out.println("負の数を入力すると終了します");

            String input = sc.nextLine();
            List<Integer> input_array = new ArrayList<>();  // 入力値のリスト

            try {
                array_num = Integer.parseInt(input);

                if (array_num > 0) {
                    for (int i = 0;i < array_num;i += 1) {
                        // 入力値をリストに追加
                        System.out.print("要素" + i + ": ");
                        input = sc.nextLine();
                        int input_val = Integer.parseInt(input);
                        input_array.add(input_val);
                    }

                    // 入力リストに対してconvert
                    System.out.print(input_array + " -> ");
                    System.out.println(app.getConverted(input_array));
                } else if (array_num == 0) {
                    System.out.println("1以上を入力してください");
                }
            } catch (Exception exp) {
                System.out.println("入力が不正です");
            }
        } while(array_num >= 0);

        sc.close();
    }
}
