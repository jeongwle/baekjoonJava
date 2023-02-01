package baekjoon.단계11_재귀.팩토리얼10872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int number = toInt(bf.readLine());
        validateNumber(number);

        StringBuilder sb = new StringBuilder();
        sb.append(factorial(number))
                .append("\n");
        System.out.print(sb);
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static void validateNumber(int number) {
        if (number < 0 || number > 12) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    static int factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}

