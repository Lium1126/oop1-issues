/**
 * オブジェクト指向プログラミング1
 * 第7回
 * 課題4-クラス
 * 空でない整数コレクションList<Integer>を引数として受け取り、ユニークな要素を除外する
 * プログラムを作成せよ
 */

package jp.ac.ait.oop1.k19061;

import java.util.*;

public class NonUniqueElements implements IKadai07_4{
    @Override
    // 注意:引数に対して破壊的な代入を行う
    public void convert(List<Integer> targetList) {

        List<Integer> checkList = new ArrayList<>(targetList);

        Iterator<Integer> itr = targetList.iterator();
        while (itr.hasNext()) {  // 次の値がある間繰り返す
            int val = itr.next();  // 次の値を取得

            // valの個数をカウントする
            int cnt = 0;
            for (int checkval : checkList) {
                if (checkval == val) cnt += 1;
            }

            // valの個数が1個なら要素を削除
            if (cnt == 1) {
                itr.remove();  // イテレータから、対象データの今見ているデータを削除
            }
        }

        return;
    }

    public static void main(String[] args) {
        Integer[] a1 = {2, 64, 256, 2, 256};             // 削除される要素が1つ(中腹)しかないケース
        Integer[] a2 = {2, 64, 256, 64, 256};            // 削除される要素が1つ(先頭)しかないケース
        Integer[] a3 = {2, 64, 64, 2, 256};              // 削除される要素が1つ(末尾)しかないケース
        Integer[] a4 = {0, 10, 20, 30, 40};              // 全ての要素がユニークなケース(空配列になる)
        Integer[] a5 = {2, 2, 3, 2, 3};                  // 全ての要素が非ユニークなケース(元の配列から何も変わらない,要素の順序が変更されていないことも確認する)
        Integer[] a6 = {7, 10, 9, 10, 10, 9, 8, 10, 6};  // ユニークな要素を削除しても、 非ユニークな要素の順序が変わらないことを確認するケース

        NonUniqueElements app = new NonUniqueElements();

        List<Integer> a = new ArrayList<>(Arrays.asList(a1));
        System.out.print(a + " -> ");
        app.convert(a);
        System.out.println(a);  // [2, 64, 256, 2, 256] → [2, 256, 2, 256]

        List<Integer> b = new ArrayList<>(Arrays.asList(a2));
        System.out.print(b + " -> ");
        app.convert(b);
        System.out.println(b);  // [2, 64, 256, 64, 256] → [64, 256, 64, 256]

        List<Integer> c = new ArrayList<>(Arrays.asList(a3));
        System.out.print(c + " -> ");
        app.convert(c);
        System.out.println(c);  // [2, 64, 64, 2, 256] → [2, 64, 64, 2]

        List<Integer> d = new ArrayList<>(Arrays.asList(a4));
        System.out.print(d + " -> ");
        app.convert(d);
        System.out.println(d);  // [0, 10, 20, 30, 40] → []

        List<Integer> e = new ArrayList<>(Arrays.asList(a5));
        System.out.print(e + " -> ");
        app.convert(e);
        System.out.println(e);  // [2, 2, 3, 2, 3] → [2, 2, 3, 2, 3]

        List<Integer> f = new ArrayList<>(Arrays.asList(a6));
        System.out.print(f + " -> ");
        app.convert(f);
        System.out.println(f);  // [7, 10, 9, 10, 10, 9, 8, 10, 6] → [10, 9, 10, 10, 9, 10]

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
                    app.convert(input_array);
                    System.out.println(input_array);
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
