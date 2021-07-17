public class Score {
    /*--フィールド---*/
    int id = 0;                   // 学生番号
    String name = "";             // 学生の氏名
    int[] subjects = new int[5];  // 5教科の点数([0]:国語,[1]:数学,[2]:理科,[3]:社会,[4]:英語)

    /*---メソッド---*/
    // 国語の点数を返す
    int getJapanese() {
        // subjects[0]を返す
        return subjects[0];
    }

    // 数学の点数を返す
    int getMathmatics() {
        // subject[1]を返す
        return subjects[1];
    }

    // 理科の点数を返す
    int getScience() {
        // subject[2]を返す
        return subjects[2];
    }

    // 社会の点数を返す
    int getSocialStudies() {
        // subject[3]を返す
        return subjects[3];
    }

    // 英語の点数を返す
    int getEnglish() {
        // subject[4]を返す
        return subjects[4];
    }

    // 国語の点数をセットする
    void setJapanese(int value) {
        // subjects[0]に引数のvalueを代入する
        subjects[0] = value;
        return;
    }

    // 数学の点数をセットする
    void setMathmatics(int value) {
        // subjects[1]に引数のvalueを代入する
        subjects[1] = value;
        return;
    }

    // 理科の点数をセットする
    void setScience(int value) {
        // subjects[2]に引数のvalueを代入する
        subjects[2] = value;
        return;
    }

    // 社会の点数をセットする
    void setSocialStudies(int value) {
        // subjects[3]に引数のvalueを代入する
        subjects[3] = value;
        return;
    }

    // 英語の点数をセットする
    void setEnglish(int value) {
        // subjects[4]に引数のvalueを代入する
        subjects[4] = value;
        return;
    }

    // 合計点を求める
    int getTotal() {
        // subjects[0]〜subjects[4]の合計を算出して返す
        int sum = 0;
        for (int subject : subjects) {
            sum += subject;
        }
        return sum;
    }

    // 平均点を求める
    double getAverage() {
        // 合計 / 教科数を算出して返します
        return (double)getTotal() / 5.0;
    }

    // 最高得点を求める
    int getHighScore() {
        // 	5教科のうち最高得点を返す(点数のみなので、同率が存在する場合も返す値は1つ)
        int maxScore = subjects[0];  // 最高得点を格納する変数(subjects[0]で初期化)
        for (int subject : subjects) {
            if (maxScore < subject) {
                maxScore = subject;
            }
        }
        return maxScore;
    }

    // 最高得点の科目名を求める
    String getHighScoreSubject() {
        // 5教科のうち最高得点だった科目名を返す(同率の科目がある場合は、カンマ区切りで科目を連結する)
        String ret = "";              // return用文字列変数
        int maxScore = getHighScore();  // 最高点数

        for (int i = 0;i < 5;i++) {
            if (subjects[i] == maxScore) {
                // 最高点数の科目が初めてでなければ、カンマで区切る
                if (!ret.equals("")) {
                    ret += ",";
                }

                // retに科目名を追加する
                switch (i) {
                    case 0:
                        ret += "国語";
                        break;
                    case 1:
                        ret += "数学";
                        break;
                    case 2:
                        ret += "理科";
                        break;
                    case 3:
                        ret += "社会";
                        break;
                    case 4:
                        ret += "英語";
                }
            }
        }

        // 生成した文字列を返す
        return ret;
    }

    // 最低得点を求める
    int getLowScore() {
        // 	5教科のうち最低得点を返す(点数のみなので、同率が存在する場合も返す値は1つ)
        int minScore = subjects[0];  // 最低得点を格納する変数(subjects[0]で初期化)
        for (int subject : subjects) {
            if (minScore > subject) {
                minScore = subject;
            }
        }
        return minScore;
    }

    // 最低得点の科目名を求める
    String getLowScoreSubject() {
        // 5教科のうち最低得点だった科目名を返す(同率の科目がある場合は、カンマ区切りで科目を連結する)
        String ret = "";              // return用文字列変数
        int minScore = getLowScore();  // 最高点数

        for (int i = 0;i < 5;i++) {
            if (subjects[i] == minScore) {
                // 最高点数の科目が初めてでなければ、カンマで区切る
                if (!ret.equals("")) {
                    ret += ",";
                }

                // retに科目名を追加する
                switch (i) {
                    case 0:
                        ret += "国語";
                        break;
                    case 1:
                        ret += "数学";
                        break;
                    case 2:
                        ret += "理科";
                        break;
                    case 3:
                        ret += "社会";
                        break;
                    case 4:
                        ret += "英語";
                }
            }
        }

        // 生成した文字列を返す
        return ret;
    }

    // 様々な情報を出力する
    void printInfo() {
        // 指定フォーマットで情報を出力する
        String str = String.format("%d %s 国語%d点,数学%d点,理科%d点,社会%d点,英語%d点", id, name, getJapanese(), getMathmatics(), getScience(), getSocialStudies(), getEnglish());
        str += String.format(" 合計%d点 平均%.2f点", getTotal(), getAverage());
        str += String.format(" 得意科目:%s %d点 苦手科目:%s %d点", getHighScoreSubject(), getHighScore(), getLowScoreSubject(), getLowScore());
        System.out.println(str);
    }
}
