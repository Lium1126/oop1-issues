/**
 * オブジェクト指向プログラミング
 * 第7回
 * 課題3-インターフェイス
 * 引数で渡されるList<String>コレクションから、それぞれの値が一意になるリストを作成し、
 * List<String>で返すプログラムを作成せよ
 */

package jp.ac.ait.oop1.k19061;

import java.util.List;

public interface IKadai07_3 {
    List<String> getUniqueList(List<String> targetList);
}