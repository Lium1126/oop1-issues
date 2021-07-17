import java.util.Scanner;

public class FuelExpenseCalcurator {
    public static void main(String[] args) {

        // Carクラスをインスタンス化する
        Car my_car = new Car();

        // Scannerクラスで標準入力を受け付ける
        Scanner in = new Scanner(System.in);

        // 燃費を入力する
        System.out.print("燃費を入力してください:");
        my_car.setFuelEfficiency(Double.parseDouble(in.nextLine()));

        // "end"と入力されるまで走行距離を入力し続け、計算する
        System.out.println("走行距離を続けて改行区切りで入力してください。(endを入力すると終了します。)");
        String in_str;  // 　1行分の入力を格納する文字列変数

        do {
            in_str = in.nextLine();
            if (in_str.equals("end")) {
                continue;
            }
            my_car.run(Double.parseDouble(in_str));
            my_car.printInfo();
        } while (!in_str.equals("end"));
    }
}
