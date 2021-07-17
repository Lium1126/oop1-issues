/**
 * オブジェクト指向プログラミング
 * 第7回
 * 課題3-クラス
 * 引数で渡されるList<String>コレクションから、それぞれの値が一意になるリストを作成し、
 * List<String>で返すプログラムを作成せよ
 */

package jp.ac.ait.oop1.k19061;

import java.util.*;

public class UniqueString implements IKadai07_3 {
    @Override
    public List<String> getUniqueList(List<String> targetList) {

        List<String> ret = new ArrayList<>(targetList);    // 返り値用リスト
        List<String> check = new ArrayList<>(targetList);  // 要素数チェック用リスト

        Iterator<String> itr = ret.iterator();
        while (itr.hasNext()) {  // 次の値がある間繰り返す
            String elem = itr.next();  // 次の値を取得

            // elemの個数をカウントする
            int cnt = 0;
            for (String checkelem : check) {
                if (checkelem.equals(elem)) cnt += 1;
            }

            // valの個数が2個以上なら要素を削除
            if (cnt >= 2) {
                itr.remove();  // イテレータから、対象データの今見ているデータを削除
            }
        }

        return ret;
    }

    public static void main(String[] args) {

        String[] a1 = {"A", "B", "B", "B", "C"};            // 中腹の要素が削除されるケース---+
        String[] a2 = {"abc", "def", "abc", "abc", "ghi"};  // 先頭の要素が削除されるケース---+--要素の順序が変わっていない点も要確認
        String[] a3 = {"A", "B", "C", "D", "C"};            // 末尾の要素が削除されるケース---+
        String[] a4 = {"a", "b", "c", "d", "e"};            // 全ての要素が元々ユニークであるケース
        String[] a5 = {"A", "B", "A", "A", "B"};            // 全ての要素が元々非ユニークであるケース(空配列になる)

        UniqueString app = new UniqueString();

        List<String> a = new ArrayList<>(Arrays.asList(a1));
        System.out.print(a + " -> ");
        System.out.println(app.getUniqueList(a));  // [A, B, B, B, C] → [A, C]

        List<String> b = new ArrayList<>(Arrays.asList(a2));
        System.out.print(b + " -> ");
        System.out.println(app.getUniqueList(b));  // [abc, def, abc, abc, ghi] → [def, ghi]

        List<String> c = new ArrayList<>(Arrays.asList(a3));
        System.out.print(c + " -> ");
        System.out.println(app.getUniqueList(c));  // [A, B, C, D, C] → [A, B, D]

        List<String> d = new ArrayList<>(Arrays.asList(a4));
        System.out.print(d + " -> ");
        System.out.println(app.getUniqueList(d));  // [a, b, c, d, e] → [a, b, c, d, e]

        List<String> e = new ArrayList<>(Arrays.asList(a5));
        System.out.print(e + " -> ");
        System.out.println(app.getUniqueList(e));  // [A, B, A, A, B] → []

        /*---以降、対話型の動作確認---*/
        Scanner sc = new Scanner(System.in);
        int array_num = 0;  // 入力値

        do {
            // ユーザにメッセージを表示
            System.out.println("\n要素数を入力してください");
            System.out.println("負の数を入力すると終了します");

            String input = sc.nextLine();
            List<String> input_array = new ArrayList<>();  // 入力値のリスト

            try {
                array_num = Integer.parseInt(input);

                if (array_num > 0) {
                    for (int i = 0;i < array_num;i += 1) {
                        // 入力値をリストに追加
                        System.out.print("要素" + i + ": ");
                        input = sc.nextLine();
                        input_array.add(input);
                    }

                    // 入力リストに対してconvert
                    System.out.print(input_array + " -> ");
                    System.out.println(app.getUniqueList(input_array));
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
