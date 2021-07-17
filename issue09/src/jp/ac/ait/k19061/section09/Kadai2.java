package jp.ac.ait.k19061.section09;

import java.util.Scanner;

public class Kadai2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean isNG = true;

        while (isNG) {
            // ユーザからのパスワード入力を受け付ける
            System.out.println("パスワードを入力してください。");
            String input = sc.nextLine();

            // パスワードとして正しい形式か判定
            try {
                isNG = !PasswordManager.validate(input);  // 入力値が正しい形式の場合はisNGにfalseが格納される
            } catch (PasswordRulesViolationException prvex) {
                System.out.println("パスワードのルール基準を満たしていません。" + prvex.getMessage());
                isNG = true;  // 勝手にループを抜けないようにしておく
            }
        }

        System.out.println("パスワードを確認しました。");
    }
}
