public class Car {
    /*---フィールド--*/
    double fuelEfficiency = 1.0;  // 燃費効率[km/L]
    double totalMileage = 0.0;    // 累積走行距離[km]
    double expendedFuel = 0.0;    // 消費燃料の累計[L]

    /*---メソッド---*/
    // fuelEfficiencyにvalueを格納する(セッタ)
    void setFuelEfficiency(double value) {
        if (value <= 0.0) {
            System.out.println("引数が正しくありません");
            System.exit(1);
        }
        fuelEfficiency = value;
    }

    // 引数で走行距離を渡す
    // 渡された情報を累積走行距離に加算、走行距離/燃費を消費燃料として消費燃料の累計に加算する
    // 今回の走行で消費した燃料を返す
    double run(double mileage) {
        // 消費燃料を計算
        double fuel = mileage / fuelEfficiency;

        totalMileage += mileage;
        expendedFuel += fuel;
        return fuel;
    }

    // 累積走行距離と消費燃料の累計を出力する
    void printInfo() {
        // 標準出力に「走行距離:00.00km 消費燃料:00.00L」のように情報出力する
        System.out.printf("走行距離:%.2fkm 消費燃料:%.2f\n", totalMileage, expendedFuel);
        return;
    }
}
