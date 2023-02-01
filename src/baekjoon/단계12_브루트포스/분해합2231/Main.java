package baekjoon.단계12_브루트포스.분해합2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int sum = toInt(bf.readLine());

        validateSum(sum);
        System.out.println(getMinConstructor(sum));
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static void validateSum(int sum) {
        if (sum < 1 || sum > 1_000_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public static int getMinConstructor(int sum) {
        int temp;
        for (int i = 1; i < sum; i++) {
            temp = calculateSum(i);
            if (temp == sum) {
                return i;
            }
        }
        return 0;
    }

    public static int calculateSum(int constructor) {
        int digits = getDigits(constructor);
        int sum = constructor;
        for (int i = 0; i < digits; i++) {
            sum += (int)(constructor / Math.pow(10, i)) % 10;
        }
        return sum;
    }


    public static int getDigits(int number) {
        int digits = 1;
        while (number / 10 != 0) {
            number /= 10;
            digits++;
        }
        return digits;
    }

}
