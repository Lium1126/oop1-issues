public class IntCollector {
    /*---フィールド---*/
    private int[] array;  // クラス内部でデータを保持する配列

    /*---コンストラクタ---*/
    //引数なしのコンストラクタ(要素数0で初期化)
    public IntCollector() {
        array = new int[0];
    }

    //指定された引数の配列とarrayが同じ配列に
    //なるように要素数及び各要素をコピーする
    public IntCollector(int[] values) {
        // this.array = valuesでは、ポインタのコピーになってしまうためNG
        this.setArray(values);
    }

    /*---メソッド---*/
    //アクセサ--------------------------------
    //フィールドarrayを返す
    public int[] getArray() {
        return array;
    }

    //指定された引数の配列とarrayが同じ配列になるように要素数及び各要素をコピーする
    public void setArray(int[] values) {
        array = new int[values.length];  // arrayを引数で渡された配列の要素数で作り直す

        // 要素をコピー
        for (int i = 0;i < values.length;i++) {
            array[i] = values[i];
        }
    }

    //指定されたインデックスの要素を返す
    //負のインデックスが指定された場合は先頭要素、
    //配列のサイズより大きいインデックスがしてされた場合は末尾要素を返す
    //配列が空の場合は0を返す
    public int getElement(int index) {
        if (array.length == 0) return 0;
        if (index < 0) return array[0];
        if (index >= array.length) return array[array.length - 1];
        return array[index];
    }

    //アクセサ以外のメソッド---------------------
    //配列の要素数を1つ増やし、配列データの末尾に1件追加する
    public void add(int value) {
        int[] newArray = new int[this.array.length + 1];  // 現在の配列より1つ要素が多い配列を準備

        // 現在の配列の値を新しい配列にコピー
        for (int i = 0;i < array.length;i++) {
            newArray[i] = array[i];
        }

        // 新しい配列の末尾にvalueを持つ要素を追加
        newArray[newArray.length - 1] = value;

        // 新しい配列を現在の配列とする
        array = newArray;
    }

    //指定された値で要素を検索し、その要素数を返す
    public int countOf(int value) {
        int cnt = 0;  // 値がvalueの要素数をカウントする変数

        // arrayの要素がvalueのものを数える
        for (int v: array) {
            if (v == value) {
                cnt++;
            }
        }

        return cnt;
    }

    //配列の要素を検索して、指定された要素と同じ値のインデックスを返す
    //もし、指定された要素がなければ、-1が返される
    public int indexOf(int value) {
        // valueを見つけた時点で、そのインデックスを返す
        for (int i = 0;i < array.length;i++) {
            if (array[i] == value) {
                return i;
            }
        }

        // 見つけられなかったら-1を返す
        return -1;
    }

    //指定されたインデックスの要素を削除し、配列自体の要素も切り詰める
    //指定されたインデックスが配列のインデックス外だった場合はなにもしない
    public void remove(int index) {
        // 指定されたインデックスが配列のインデックス外か判定する
        if (index < 0 || array.length <= index) {
            // 指定されたインデックスが配列のインデックス外なら、何もしない
            return;
        }

        // 指定されたインデックスは配列のインデックス内である
        else {
            int[] newArray = new int[array.length - 1];  // 現在の配列より要素数が1少ない配列を準備
            int cnt = 0;                                 // 新しい配列にコピーした要素の数

            // 新しい配列に現在の配列をコピーしていく
            // 削除対象のインデックスのときは飛ばす
            for (int i = 0; i < array.length;i++) {
                if (i == index) {
                    // 削除対象はコピーしない
                    continue;
                }
                newArray[cnt] = array[i];
                cnt++;
            }

            // 新しい配列を現在の配列とする
            array = newArray;
        }
    }

    //フィールドarrayに生成されている要素を、「結果の表示例」を参考に標準出力に画面表示する
    public void print() {
        System.out.print("[");
        for (int i = 0;i < array.length;i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    //動作確認用エントリポイント(mainメソッド)-----
    /*
    public static void main(String[] args) {
        // 引数なしコンストラクタで初期化
        IntCollector ic = new IntCollector();

        // 空要素の状態での動作確認
        System.out.println("1.引数なしコンストラクタで作られた、空の配列");

        // getArray()メソッドで正しく配列を取得できているか試す
        // ic.print()の動作確認はこの後なので、取得した配列を直接参照することで確認する
        System.out.println("getArray()メソッドの動作確認---------");
        int[] arr = ic.getArray();
        System.out.println("要素数:" + arr.length);
        System.out.print("内容:{");
        for (int i = 0;i < arr.length;i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(", ");
        }
        System.out.println("}");

        // print()メソッドで正しく配列の内容が表示されるか試す
        // ここでは空配列の表示が正しいか確認し、これ以降は
        // その他のメソッドの結果確認とともに非空配列での表示が正しいかを確認している
        System.out.println("print()メソッドの動作確認------------");
        ic.print();

        // setArray()メソッドによって任意の配列がクラス内の配列に格納されるか試す
        System.out.println("setArray()メソッドの動作確認---------");
        System.out.println("{0, 1, 1, 2, 3, 5, 8}をセット");
        int[] arr2  = {0, 1, 1, 2, 3, 5, 8};
        ic.setArray(arr2);
        ic.print();

        // add()メソッドによって正しく要素が追加されるか試す
        System.out.println("add()メソッドの動作確認--------------");
        ic.print();
        System.out.println("13を追加");
        ic.add(13);
        ic.print();

        // getElement()メソッドによって指定したインデックスの値を正しく取得できるか試す
        // 配列の中腹の要素、先頭(0番地)・末尾(array.length-1番地)の要素、配列のサイズ外を指定した
        // 場合の結果を確認する
        System.out.println("getElement()メソッドの動作確認-------");
        ic.print();
        System.out.println("4番地目の要素:" + ic.getElement(4));
        System.out.println("先頭要素:" + ic.getElement(0));
        System.out.println("末尾要素:" + ic.getElement(ic.getArray().length - 1));
        System.out.println("-5番地目を指定:" + ic.getElement(-5));
        System.out.println("100番地目を指定:" + ic.getElement(100));

        // countOf()メソッドによって正しく要素が数えられているか試す
        // 要素の数が1個のもの、複数のもの、0個のもので正しく数えられているか確認する
        System.out.println("countOf()メソッドの動作確認----------");
        ic.print();
        System.out.println("5の個数:" + ic.countOf(5));
        System.out.println("1の個数:" + ic.countOf(1));
        System.out.println("100の個数:" + ic.countOf(100));

        // indexOf()メソッドによって正しくインデックスを取得できているか試す
        // 配列の中腹の要素、複数存在する要素、先頭・末尾の要素、存在しない要素
        // の4パターンを指定して、正しく動作しているか確認する
        System.out.println("indexOf()メソッドの動作確認----------");
        ic.print();
        System.out.println("3のインデックス:" + ic.indexOf(3));
        System.out.println("1のインデックス:" + ic.indexOf(1));
        System.out.println("13のインデックス:" + ic.indexOf(13));
        System.out.println("0のインデックス:" + ic.indexOf(0));
        System.out.println("-5のインデックス:" + ic.indexOf(-5));

        // remove()メソッドによって正しく要素が削除されるか試す
        // 配列の中腹の要素、先頭・末尾の要素、配列外のインデックスを指定して
        // その全てで正しく動作するか確認する
        System.out.println("remove()メソッドの動作確認-----------");
        System.out.print("削除前:");
        ic.print();
        System.out.print("4番地目を削除:");
        ic.remove(4);
        ic.print();
        System.out.print("末尾を削除:");
        ic.remove(ic.getArray().length - 1);
        ic.print();
        System.out.print("先頭を削除:");
        ic.remove(0);
        ic.print();
        System.out.print("-1番地目を削除:");
        ic.remove(-1);
        ic.print();
        System.out.print("100番地目を削除:");
        ic.remove(100);
        ic.print();
        System.out.println("");

        // 引数ありコンストラクタで正しく初期化されているか確認する
        System.out.println("2.引数ありコンストラクタで作られた配列");
        System.out.println("引数に{10, 20, 300, 4000}を渡して初期化");
        int[] arr3 = {10, 20, 300, 4000};
        ic = new IntCollector(arr3);
        ic.print();
    }
    */
}
