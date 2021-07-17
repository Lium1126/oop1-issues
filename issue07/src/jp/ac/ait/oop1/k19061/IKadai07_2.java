/**
 * オブジェクト指向プログラミング
 * 第7回
 * 課題2-インターフェイス
 * 数値コレクション(List<Integer>)をFizzBuzz変換したリストList<String>
 * を返すプログラムを作成せよ
 */

package jp.ac.ait.oop1.k19061;

import java.util.List;

public interface IKadai07_2 {
    List<String> getConverted(List<Integer> targetList);
}
