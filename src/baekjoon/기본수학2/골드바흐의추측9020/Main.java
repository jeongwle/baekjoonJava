package baekjoon.기본수학2.골드바흐의추측9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        final int CASE = toInt(bf.readLine());
        for (int i = 0; i < CASE; i++) {
            int param = toInt(bf.readLine());
            GoldbachPartition gp = new GoldbachPartition(param);
            System.out.println(gp.makePartition());
        }
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class GoldbachPartition {
    static private final int[] ERATHOSTHENES = new int[10001];
    private final int INPUT_NUM;

    static {
        setErathosthenes();
    }

    GoldbachPartition(int number) {
        validateInput(number);
        INPUT_NUM = number;
    }

    private void validateInput(int input) {
        if (input < 4 || input > 10000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
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

    private boolean isPrimeNumber(int number) {
        return ERATHOSTHENES[number] == 0;
    }

    public String makePartition() {
        int min = 5000;
        String result = "";
        for (int i = (int) Math.sqrt(INPUT_NUM); i < INPUT_NUM; i++) {
            int prime = INPUT_NUM - i;
            if (isPrimeNumber(i) && isPrimeNumber(prime)) {
                if (getDiff(i, prime) < min) {
                    min = getDiff(i, prime);
                    result = i + " " + prime;
                }
            }
        }
        return result;
    }

    private int getDiff(int prime1, int prime2) {
        return Math.abs(prime1 - prime2);
    }

}

