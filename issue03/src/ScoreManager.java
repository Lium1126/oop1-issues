import java.util.Scanner;

public class ScoreManager {
    public static void main(String[] args) {
        // Scoreクラスをインスタンス化
        Score s = new Score();

        // 標準入力をScannerで取得する
        Scanner in = new Scanner(System.in);

        // 出席番号を入力
        System.out.print("出席番号を入力してください:");
        s.id = Integer.parseInt(in.nextLine());
        // 氏名を入力
        System.out.print("氏名を入力してください:");
        s.name = in.nextLine();
        // 国語の点数を入力
        System.out.print("国語の点数を入力してください:");
        s.setJapanese(Integer.parseInt(in.nextLine()));
        // 数学の点数を入力
        System.out.print("数学の点数を入力してください:");
        s.setMathmatics(Integer.parseInt(in.nextLine()));
        // 理科の点数を入力
        System.out.print("理科の点数を入力してください:");
        s.setScience(Integer.parseInt(in.nextLine()));
        // 社会の点数を入力
        System.out.print("社会の点数を入力してください:");
        s.setSocialStudies(Integer.parseInt(in.nextLine()));
        // 英語の点数を入力
        System.out.print("英語の点数を入力してください:");
        s.setEnglish(Integer.parseInt(in.nextLine()));

        // 情報を表示
        s.printInfo();
    }
}
