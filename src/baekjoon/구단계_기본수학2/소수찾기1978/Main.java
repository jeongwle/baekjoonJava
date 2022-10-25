package baekjoon.구단계_기본수학2.소수찾기1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        final int CASE = toInt(bf.readLine());
        validateFirstInput(CASE);

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        if (st.countTokens() != CASE) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        int result = 0;
        while (st.hasMoreTokens()) {
            PrimeNumber pn = new PrimeNumber(toInt(st.nextToken()));
            if (pn.isPrimeNumber()) {
                result++;
            }
        }
        System.out.println(result);
    }

    static void validateFirstInput(int number) {
        if (number < 1 || number > 100) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class PrimeNumber {
    static final int[] PRIME = new int[1001];
    private final int NUMBER;
    static{
        PRIME[2] = 1;
        PRIME[3] = 1;
    }

    PrimeNumber(int number) {
        validateNumber(number);
        NUMBER = number;
    }

    private void validateNumber(int number) {
        if (number < 1 || number > 1000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public boolean isPrimeNumber() {
        if (NUMBER == 1) {
            return false;
        }
        if (PRIME[NUMBER] == 1) {
            return true;
        }
        for (int i = 2; i < NUMBER; i++) {
            if (NUMBER % i == 0) {
                return false;
            }
        }
        PRIME[NUMBER] = 1;
        return true;
    }
}
