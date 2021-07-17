/**
 * オブジェクト指向プログラミング
 * 第7回
 * 課題5-インターフェイス
 * 郵便番号検索プログラムを作成せよ
 */

package jp.ac.ait.oop1.k19061;

import java.util.Map;

public interface IKadai07_5 {
    Map<String, String> searchByCode(String postalCode);
    Map<String, String> searchByAddress(String addressText);
}
