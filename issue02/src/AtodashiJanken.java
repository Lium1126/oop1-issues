import java.util.Scanner;

public class AtodashiJanken {
    public static void main(String[] args) {

        // ランダムな数値を生成して、変数に待機する
        int randNum = new java.util.Random().nextInt(3);

        // 生成したランダムな値を元に「0:グー,1:チョキ,2:パー」を表示
        System.out.print("コンピュータは");
        switch (randNum) {
            case 0:
                System.out.print("グー");
                break;
            case 1:
                System.out.print("チョキ");
                break;
            case 2:
                System.out.print("パー");
                break;
        }
        System.out.println("を出します。");

        // 入力を促すメッセージを表示し、入力を受け付ける
        System.out.println("何を出しますか？(0:グー,1:チョキ,2:パー)");
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();
        int userNum = Integer.parseInt(inputLine);

        // 入力が不正でないか判定する
        if (userNum < 0 || 2 < userNum) {
            System.out.println("あなたの出した手が判定できません。勝負はしません。");
        } else {
            // 勝敗を判定する
            String judge[][] = {
                    {"あいこ", "負け", "勝ち"},
                    {"勝ち", "あいこ", "負け"},
                    {"負け", "勝ち", "あいこ"}
            };
            String result = judge[randNum][userNum];
            if (randNum == userNum) {
                System.out.println("あなたとコンピュータは" + result + "です。");
            } else {
                System.out.println("あなたの" + result + "です。");
            }
        }

        // Scannerを閉じる
        in.close();

        return;
    }
}
