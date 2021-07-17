public class TimesTable {
    /*---フィールド---*/
    private int width;      // 九九表の幅(列数)
    private int height;     // 九九表の高さ(行数)
    private int[][] array;  // 九九表(コンストラクタにて配列の要素数及び内容を初期化します)

    /*---コンストラクタ---*/
    //このクラスは、初期化に高さデータと幅データが必要なため引数なしコンストラクタは外部から呼ばれないようにします
    private TimesTable() {}

    //引数をそれぞれのフィールドに代入するとともに、フィールドarrayに値を設定します。
    public TimesTable(int width, int height) {
        // 引数に負の数が渡された場合
        if (width < 0 || height < 0) {
            this.width = 0;   // 幅に0を代入
            this.height = 0;  // 高さに0を代入
            array = new int[0][0];
        }
        // 引数に適切な値が渡された場合
        else {
            // フィールドwidth, heightの初期化
            this.width = width;
            this.height = height;

            // arrayの初期化
            array = new int[height][width];
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    array[h][w] = (h + 1) * (w + 1);
                }
            }

        }
    }

    /*---メソッド---*/
    //アクセサ--------------------------------
    //フィールドwidthを返す
    public int getWidth() {
        return width;
    }

    //フィールドheightを返す
    public int getHeight() {
        return height;
    }

    //フィールドarrayを返す
    public int[][] getArray() {
        return array;
    }

    //アクセサ以外のメソッド---------------------
    //フィールドarrayに生成されている九九表を、「結果の表示例」の形式で標準出力に画面表示します
    public void print() {
        int max_digit = 0;      // 最大値の桁数
        int product_digit = 0;  // 配列のある要素の桁数

        // 九九表が正しく生成されている場合(width>0かつheight>0)に
        // 九九表に含まれる最大値の桁数を取得する
        if (width > 0 && height > 0) {
            max_digit = String.valueOf(array[height - 1][width - 1]).length();
        }

        // 九九表を表示
        for (int h = 0;h < height;h++) {
            for (int w = 0; w < width; w++) {
                // 表示する要素の桁数を求める
                product_digit = String.valueOf(array[h][w]).length();

                // 表示する要素の桁数と最大値の桁数+1との差分、空白パディング
                System.out.print("|");
                for (int i = 0;i < ((max_digit + 1) - product_digit);i++) System.out.print(" ");

                // 要素を表示
                System.out.print(array[h][w]);
            }
            System.out.println("|");
        }
    }

    //動作確認用エントリポイント(mainメソッド)-----
    /*
    public static void main(String[] args) {

        TimesTable app;
        int[][] table;

        // 引数なしのコンストラクタ(TimesTable())は自クラスから呼び出すとエラーにならないが、
        // 自クラスの開発者は引数なしのコンストラクタを呼び出してはならないことを分かっているはずなので問題ない
        // 他クラスからの呼び出しはprivate修飾子によってコンパイルエラーとなる
        //app = new TimesTable();
        //app.print();

        // 幅3,高さ4の掛け算表を生成して動作確認する
        // 想定されやすく、一般的によく使われるであろう数の組み合わせで正しく動作するかを試す
        System.out.println("幅:3, 高さ:4の掛け算表を生成");
        app = new TimesTable(3, 4);
        System.out.println("getWidth(),getHeight()メソッドの動作確認--------");
        System.out.println("幅:" + app.getWidth());
        System.out.println("高さ:" + app.getHeight());
        System.out.println("getArray()メソッドの動作確認--------------------");
        table = app.getArray();
        System.out.println("{");
        for (int[] col: table) {
            System.out.printf("\t{");
            for (int i = 0;i < col.length;i++) {
                System.out.print(col[i]);
                if (i != col.length - 1) System.out.print(", ");
            }
            System.out.println("}");
        }
        System.out.println("}");
        System.out.println("print()メソッドの動作確認-----------------------");
        app.print();
        System.out.println("");

        // 幅5,高さ-5の掛け算表を生成して動作確認する
        // 幅、高さのいずれかに負の数が与えられた場合の動作を試す
        System.out.println("幅:5, 高さ:-5の掛け算表を生成");
        app = new TimesTable(5, -5);
        System.out.println("getWidth(),getHeight()メソッドの動作確認--------");
        System.out.println("幅:" + app.getWidth());
        System.out.println("高さ:" + app.getHeight());
        System.out.println("getArray()メソッドの動作確認--------------------");
        table = app.getArray();
        System.out.println("{");
        for (int[] col: table) {
            System.out.printf("\t{");
            for (int i = 0;i < col.length;i++) {
                System.out.print(col[i]);
                if (i != col.length - 1) System.out.print(", ");
            }
            System.out.println("}");
        }
        System.out.println("}");
        System.out.println("print()メソッドの動作確認-----------------------");
        app.print();
        System.out.println("掛け算表が表示されないのが正しい");
        System.out.println("");

        // 幅100,高さ100の掛け算表を生成して動作確認する
        // 巨大な表になる際の動作を試す
        // また、表に含まれる最大値は10000であり、この値だけが5桁になるため、
        // 正しく桁を揃えて表を出力できているか否かを確認する目的もある
        System.out.println("幅:100, 高さ:100の掛け算表を生成");
        app = new TimesTable(100, 100);
        System.out.println("getWidth(),getHeight()メソッドの動作確認--------");
        System.out.println("幅:" + app.getWidth());
        System.out.println("高さ:" + app.getHeight());
        System.out.println("getArray()メソッドの動作確認--------------------");
        table = app.getArray();
        System.out.println("{");
        for (int[] col: table) {
            System.out.printf("\t{");
            for (int i = 0;i < col.length;i++) {
                System.out.print(col[i]);
                if (i != col.length - 1) System.out.print(", ");
            }
            System.out.println("}");
        }
        System.out.println("}");
        System.out.println("print()メソッドの動作確認-----------------------");
        app.print();
    }
    */
}
