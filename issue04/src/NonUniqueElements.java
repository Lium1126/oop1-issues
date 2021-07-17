public class NonUniqueElements {
    /*---メソッド---*/
    //与えられたIntCollectorの非ユニークな要素だけでできているリストを返す
    public IntCollector convert(IntCollector arr) {
        IntCollector target = new IntCollector();  // 削除対象リスト

        // 削除対象のインデックスをtargetに降順で追加していく
        for (int i = arr.getArray().length - 1;i >= 0;i--) {
            if (arr.countOf(arr.getElement(i)) == 1) {   // インデックスiの要素がユニークである
                target.add(i);
            }
        }

        // targetに格納されたインデックスの要素を削除していく
        // targetは降順であるため、末尾側から削除される
        IntCollector non_unique = new IntCollector(arr.getArray());  // 削除対象を実際に削除する配列(arrの配列で初期化)
        for (int target_index: target.getArray()) {
            non_unique.remove(target_index);
        }

        // ユニークな要素を削除した配列を返す
        return non_unique;
    }

    /*---動作確認用エントリポイント---*/
    public static void main(String[] args) {

        // {2, 64, 256, 2, 256}:削除される要素が1つしかないテストケース
        // 削除される要素が中腹の場合
        int[] arr1 = {2, 64, 256, 2, 256};
        IntCollector arg = new IntCollector(arr1);
        NonUniqueElements non_unique = new NonUniqueElements();
        IntCollector result = non_unique.convert(arg);
        System.out.print("before:");
        arg.print();
        System.out.print("after :");
        result.print();
        System.out.println("");

        // {2, 64, 256, 64, 256}:削除される要素が1つしかないテストケース
        // 削除される要素が先頭の場合
        int[] arr2 = {2, 64, 256, 64, 256};
        arg.setArray(arr2);
        result = non_unique.convert(arg);
        System.out.print("before:");
        arg.print();
        System.out.print("after :");
        result.print();
        System.out.println("");

        // {2, 64, 64 2, 256}:削除される要素が1つしかないテストケース
        // 削除される要素が末尾の場合
        int[] arr3 = {2, 64, 64, 2, 256};
        arg.setArray(arr3);
        result = non_unique.convert(arg);
        System.out.print("before:");
        arg.print();
        System.out.print("after :");
        result.print();
        System.out.println("");

        // {0, 10, 20, 30, 40}:全ての要素がユニークであるテストケース
        // 結果は空配列となれば正しい
        int[] arr4 = {0, 10, 20, 30, 40};
        arg.setArray(arr4);
        result = non_unique.convert(arg);
        System.out.print("before:");
        arg.print();
        System.out.print("after :");
        result.print();
        System.out.println("");

        // {2, 2, 3, 2, 3}:全ての要素が非ユニークであるテストケース
        // 結果は配列に何も変化がなければ正しい
        // また、要素の順序が変更されていないことも確認する
        int[] arr5 = {2, 2, 3, 2, 3};
        arg.setArray(arr5);
        result = non_unique.convert(arg);
        System.out.print("before:");
        arg.print();
        System.out.print("after :");
        result.print();
        System.out.println("");

        // {7, 10, 9, 10, 10, 9, 8, 10, 6}:ユニークな要素を削除しても、
        // 非ユニークな要素の順序が変わらないことを確認するテストケース
        int[] arr6 = {7, 10, 9, 10, 10, 9, 8, 10, 6};
        arg.setArray(arr6);
        result = non_unique.convert(arg);
        System.out.print("before:");
        arg.print();
        System.out.print("after :");
        result.print();
    }
}
