package baekjoon.단계15_정수론및조합론.팩토리얼0의개수1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int number = toInt(bf.readLine());
        if (number <= 4) {
            System.out.println(0);
            return;
        }

        int result = 0;
        for (int i = 2; i <= number; i++) {
            int temp = i;
            while (temp % 5 == 0) {
                result++;
                temp /= 5;
            }
        }
        System.out.println(result);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
