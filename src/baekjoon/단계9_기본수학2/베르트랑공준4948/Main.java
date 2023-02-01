package baekjoon.단계9_기본수학2.베르트랑공준4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int number = toInt(bf.readLine());
            if (number == 0) {
                break;
            }
            Bertrand bertrand = new Bertrand(number);
            System.out.println(bertrand.countPrimeNumber());
        }
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class Bertrand {
    private static final int[] ERATHOSTHENES = new int[246913]; // 123456 * 2 + 1
    private final int INPUT_NUM;

    static {
        setErathosthenes();
    }

    private static void setErathosthenes() {
        for (int i = 2; i < ERATHOSTHENES.length; i++) {
            if (ERATHOSTHENES[i] == 1) {
                continue;
            }

            for (int j = i * 2; j < ERATHOSTHENES.length; j += i) {
                ERATHOSTHENES[j] = 1;
            }
        }
    }

    Bertrand(int number) {
        validateInput(number);
        INPUT_NUM = number;
    }

    private void validateInput(int input) {
        if (input < 1 || input > 123456) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public int countPrimeNumber() {
        int count = 0;
        for (int i = INPUT_NUM + 1; i <= INPUT_NUM * 2; i++) {
            if (ERATHOSTHENES[i] == 0) {
                count++;
            }
        }
        return count;
    }
}
