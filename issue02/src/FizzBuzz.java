public class FizzBuzz {
    public static void main(String[] args) {

        // 1~100の数値に対し、3の倍数なら"Fizz"、5の倍数なら"Buzz"、その両方なら"FizzBuzz"と表示する
        for (int i = 1;i <= 100;i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

        return;
    }
}
