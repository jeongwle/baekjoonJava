package baekjoon.단계9_기본수학2.소수2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int[] PRIME = new int[10001];
    static {
        PRIME[2] = 1;
        for (int i = 3; i < PRIME.length; i++) {
            setPrime(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        final int START = toInt(bf.readLine());
        final int END = toInt(bf.readLine());

        validateInput(START);
        validateInput(END);

        int sum = 0;
        int min = 0;

        for (int i = START; i <= END; i++) {
            if (PRIME[i] == 1) {
                sum += i;
                if (min == 0) {
                    min = i;
                }
            }
        }
        printResult(sum, min);
    }

    static void setPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return ;
            }
        }
        PRIME[number] = 1;
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static void validateInput(int number) {
        if (number < 1 || number > 10000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    static void printResult(int sum, int min) {
        if (min == 0) {
            System.out.println(-1);
            return ;
        }
        System.out.println(sum);
        System.out.println(min);
    }
}

