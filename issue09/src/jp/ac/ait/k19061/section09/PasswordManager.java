package jp.ac.ait.k19061.section09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordManager {
    public static boolean validate(String password)
            throws PasswordRulesViolationException {

        //入力可能な記号をリストで保持
        List<Character> symbolList = new ArrayList<>();
        symbolList.add(',');
        symbolList.add('.');
        symbolList.add('+');
        symbolList.add('-');
        symbolList.add('*');
        symbolList.add('/');
        symbolList.add('=');
        symbolList.add('_');
        symbolList.add('#');
        symbolList.add('!');
        symbolList.add('?');
        symbolList.add('@');
        symbolList.add(' ');

        // 含まれてはいけない文字列
        Set<String> unusableStringSet = new HashSet<>();
        unusableStringSet.add("password");
        unusableStringSet.add("p@ssword");
        unusableStringSet.add("p@ssw0rd");
        unusableStringSet.add("p@55word");
        unusableStringSet.add("p@55w0rd");
        unusableStringSet.add("qwerty");
        unusableStringSet.add("asdfgh");
        unusableStringSet.add("zxcvbn");
        unusableStringSet.add("abcdef");
        unusableStringSet.add("123456");

        // 変数宣言
        int num_of_uppercase = 0;        // passwordに含まれている大文字アルファベットの個数
        int num_of_lowercase = 0;        // passwordに含まれている小文字アルファベットの個数
        int num_of_digit = 0;            // passwordに含まれている数字の個数
        int num_of_usable_symbol = 0;    // passwordに含まれている利用可能記号の個数

        /*---以下、パスワードの形式に合致しているか、条件を一つずつ判定---*/
        // 1.パスワードは16文字以上128文字以下とする
        // 1-1.16文字以上かチェック
        if (password.length() < 16) {
            throw new PasswordRulesViolationException("パスワードは16文字以上である必要があります。");
        }

        // 1-2.128文字以下かチェック
        if (password.length() > 128) {
            throw new PasswordRulesViolationException("パスワードは128文字以下である必要があります。");
        }

        // 2.パスワードにはアルファベット(a-z, A-Z)と数字と一部の記号が使用できる
        // 2-1.passwordを走査的に調べ、アルファベット、数字、利用可能記号の個数を数える
        for (int i = 0;i < password.length();i++) {
            // 2-1-1.一文字ずつ取得する
            Character c = password.charAt(i);

            // 2-1-2.アルファベット
            if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c)) num_of_uppercase += 1;       // 大文字
                else if (Character.isLowerCase(c)) num_of_lowercase += 1;  // 小文字
            }

            // 2-1-3.数字
            if (Character.isDigit(c)) num_of_digit += 1;

            // 2-1-4.利用可能記号
            if (symbolList.contains(c)) num_of_usable_symbol += 1;
        }

        // 2-2.アルファベット、数字、利用可能記号の個数の合計がpasswordの文字数と一致しない場合、利用できない文字が含まれている
        if ((num_of_uppercase + num_of_lowercase + num_of_digit + num_of_usable_symbol) != password.length()) {
            throw new PasswordRulesViolationException("パスワードに使用できない文字が含まれています。");
        }

        // 3.パスワードには必ず、大文字のアルファベット、小文字のアルファベット、数字、記号のうちそれぞれ一文字以上使用されること
        if (num_of_uppercase < 1 || num_of_lowercase < 1 || num_of_digit < 1 || num_of_usable_symbol < 1) {
            throw new PasswordRulesViolationException("パスワードには大文字のアルファベット、小文字のアルファベット、数字、記号がそれぞれ一文字以上使用されている必要があります。");
        }

        // 4.容易に推測される文字列(unusableStringSetにて管理)を含む事はできない
        String lower_password = password.toLowerCase();
        for (String unusable_string : unusableStringSet) {
            if (lower_password.contains(unusable_string)) {
                throw new PasswordRulesViolationException("パスワードには容易に推測される文字列を含むことはできません。");
            }
        }

        // 最後までチェックを突破できている場合、パスワードのルールはOK
        return true;
    }
}
