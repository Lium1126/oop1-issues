import java.util.Scanner;

public class Saiten {
    public static void main(String[] args) {

        // 入力を促すメッセージを表示
        System.out.println("テストの点数を入力してください。");

        // 入力を受け付ける
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();

        // 入力された文字列を整数値に変換
        int score = Integer.parseInt(inputLine);

        // 0~100の範囲外だったら終了
        if (score < 0 || 100 < score) {
            System.out.println("入力された値は点数として正しくありません。");
            return;
        }

        // 範囲内だったら、メッセージを点数に応じて表示
        if (score < 20) {
            System.out.println("不合格です。来年もう一年頑張りましょう。");
        } else if (score < 60) {
            System.out.println("不合格です。再テストを行いましょう！");
        } else {
            System.out.println("合格です。おめでとう！");
        }

        // Scannerを閉じる
        in.close();

        return;
    }
}
