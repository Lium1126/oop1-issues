public class Fibonacci {
    /*---メソッド---*/
    //引数に渡されたn以下のフィボナッチ数列を格納したカスタム配列を返す
    public IntCollector get(int n) {
        IntCollector ic = new IntCollector();  // フィボナッチ数列を格納するカスタム配列

        // 基底を配列に追加
        if (n >= 0) ic.add(0);
        if (n >= 1) ic.add(1);

        if (n >= 1) {
            // 規定が順当に定められている場合のみ、
            // n以下のフィボナッチ数を配列に追加していく
            int num = ic.getElement(ic.getArray().length - 2) + ic.getElement(ic.getArray().length - 1);  // 追加するフィボナッチ数

            while (num <= n) {
                ic.add(num);
                num = ic.getElement(ic.getArray().length - 2) + ic.getElement(ic.getArray().length - 1);
            }
        }

        return ic;
    }

    /*---動作確認用エントリポイント---*/
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();  // Fibonacciクラスをインスタンス化

        // 直感で確認できる程度の規模のテストケース
        System.out.println("5以下のフィボナッチ数列");
        IntCollector ic = fib.get(5);
        ic.print();

        // 模範解答が示されているテストケース
        System.out.println("10000以下のフィボナッチ数列");
        ic = fib.get(10000);
        ic.print();

        // [0,1]でなく[0,1,1]と表示されるか確認するためのテストケース
        System.out.println("1以下のフィボナッチ数列");
        ic = fib.get(1);
        ic.print();

        // []でなく[0]と表示されるか確認するためのテストケース
        System.out.println("0以下のフィボナッチ数列");
        ic = fib.get(0);
        ic.print();

        // 不適な引数の際は空配列になることを確認するテストケース
        System.out.println("-5以下のフィボナッチ数列");
        ic = fib.get(-5);
        ic.print();
    }
}
