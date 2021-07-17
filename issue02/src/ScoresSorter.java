public class ScoresSorter {
    public static void main(String[] args) {

        // 特典が格納された変数の準備
        String[] names = {"佐藤一郎", "鈴木次郎", "高橋三郎", "田中四郎", "伊藤五郎", "渡辺六郎", "山本七子", "中村八郎", "小林九", "加藤十子"};
        int[][] scores = {
                {100,30,50,40,50,60,70,80,95,10},
                {30,55,45,60,65,50,80,25,100,35},
                {90,75,35,90,65,60,80,25,0,20},
                {10,85,25,70,90,80,60,50,40,30},
                {60,40,30,50,70,70,70,70,15,55},
        };

        // 各々の合計点を求める
        int sum[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0;i < scores.length;i++) {
            for (int j = 0;j < scores[i].length;j++) {
                sum[j] += scores[i][j];
            }
        }

        // 合計点と名前をソートする(バブルソート)
        for (int i = 0;i < sum.length - 1;i++) {
            for (int j = i + 1; j < sum.length;j++) {
                if (sum[i] < sum[j]) {
                    // 合計点の並び替え
                    int tmpScore = sum[j];
                    sum[j] = sum[i];
                    sum[i] = tmpScore;

                    // 名前の並び替え
                    String tmpName = names[j];
                    names[j] = names[i];
                    names[i] = tmpName;
                }
            }
        }

        // ソート後の名前と合計点を表示
        for (int i = 0;i < names.length;i++) {
            System.out.println(names[i] + ":" + sum[i]);
        }

        return;
    }
}
