package baekjoon.팔단계_기본수학2.소인수분해11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrimeFactorization pf = new PrimeFactorization(toInt(bf.readLine()));
        pf.primeFactorization();
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

// 소인수분해 클래스
class PrimeFactorization {
    private static final HashMap<Integer, Boolean> PRIME = new HashMap<>();
    private final int INPUT_NUMBER;
    static {
        PRIME.put(2, true);
    }

    PrimeFactorization(int input) {
        validateInput(input);
        INPUT_NUMBER = input;
    }

    private void validateInput(int input) {
        if (input < 1 || input > 10_000_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public void primeFactorization() {
        primeFactorization(INPUT_NUMBER);
    }

    private void primeFactorization(int number) {
        for (int i = 2; i <= number; i++) {
            if (number % i == 0 && isPrimeNumber(i)) {
                System.out.println(i);
                primeFactorization(number / i);
                break;
            }
        }
    }

    private boolean isPrimeNumber(int input) {
        if (input == 1) {
            return false;
        }
        if (PRIME.containsKey(input)) {
            return true;
        }
        for (int i = 2; i < input; i++) {
            if (input % i == 0) {
                return false;
            }
        }
        PRIME.put(input, true);
        return true;
    }
}