public class UtilityMethods {
    // 1-1.浮動小数点型の数値を0.00形式でフォーマットして画面出力するメソッド
    void printCurrency(double d) {
        System.out.printf("%.2f\n", d);
    }

    // 1-2.整数値加算メソッド
    int add(int a, int b) {
        return a + b;
    }

    // 1-3.整数値同士の除算メソッド
    double division(int a, int b) {
        // キャストして倍精度実数型で割り算する
        return (double)a / (double)b;
    }

    // 1-4.生命、宇宙、そして万物についての究極の疑問の答えメソッド
    String getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything() {
        // 750ミリ秒待つ
        try{
            Thread.sleep(750);
        }catch(InterruptedException e){}

        // "42"という文字列を返す
        return "42";
    }

    // 動作確認(mainメソッドの実装)
    public static void main(String[] args) {
        UtilityMethods app = new UtilityMethods();

        // 1-1.浮動小数点型の数値を0.00形式でフォーマットして画面出力するメソッド
        System.out.println("1-1.浮動小数点型の数値を0.00形式でフォーマットして画面出力するメソッド");
        app.printCurrency(1.234567);
        app.printCurrency(123456.789);
        app.printCurrency(0);
        app.printCurrency(Math.sqrt(2.0));
        System.out.print("\n");

        // 1-2.整数値加算メソッド
        System.out.println("1-2.整数値加算メソッド");
        System.out.println("1 + 2 = " + app.add(1, 2));
        System.out.println("-5 + 3 = " + app.add(-5, 3));
        System.out.println("123 + 456 = " + app.add(123, 456));
        System.out.print("\n");

        // 1-3.整数値同士の除算メソッド
        System.out.println("1-3.整数値同士の除算メソッド");
        System.out.println("6 / 3 = " + app.division(6, 3));
        System.out.println("1 / 2 = " + app.division(1, 2));
        System.out.println("1 / 3 = " + app.division(1, 3));
        System.out.print("\n");

        // 1-4.生命、宇宙、そして万物についての究極の疑問の答えメソッド
        System.out.println("1-4.生命、宇宙、そして万物についての究極の疑問の答えメソッド");
        System.out.println(app.getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything());
    }
}
