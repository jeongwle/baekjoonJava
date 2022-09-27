package baekjoon.십단계_재귀.피보나치수10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = toInt(bf.readLine());
        validateNumber(number);

        StringBuilder sb = new StringBuilder();
        sb.append(fibonacci(number))
                .append("\n");
        System.out.print(sb);
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static void validateNumber(int number) {
        if (number < 0 || number > 20) {
            throw new RuntimeException("잘못되 입력입니다.");
        }
    }

    static int fibonacci(int number) {
        if (number == 0) {
            return 0;
        }
        if (number < 3) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
