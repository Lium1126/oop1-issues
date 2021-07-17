import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {

        //　入力を促すメッセージを表示し、入力を受け付ける
        System.out.println("整数値を入力してください");
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();

        // 入力された文字列を整数値に変換する
        // 数字でない文字が入力された場合は、エラーが出て終了
        int num = Integer.parseInt(inputLine);

        // 入力値が素数かどうか判定
        if (num < 2) {  // 2未満の整数は素数ではない
            System.out.println(num + "は素数ではありません");
        } else {        // 2以上の整数に対して、素数判定
            int primeFlag = 1;  // 1:素数である,0:素数でない
            for (int i = 2; i <= num - 1 && primeFlag == 1;i++) {
                if (num % i == 0) {
                    primeFlag = 0;
                }
            }

            // 判定結果を表示
            if (primeFlag == 1) {
                System.out.println(num + "は素数です");
            } else {
                System.out.println(num + "は素数ではありません");
            }
        }

        return;
    }
}
