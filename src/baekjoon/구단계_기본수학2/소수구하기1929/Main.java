package baekjoon.구단계_기본수학2.소수구하기1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int start = toInt(st.nextToken());
        int end = toInt(st.nextToken());

        PrintPrimeNumber ppn = new PrintPrimeNumber(start, end);
        ppn.printResult();
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class PrintPrimeNumber {
    private static final HashMap<Integer, Boolean> PRIME = new HashMap<>();
    private static final int[] ERATHOSTHENES = new int[1_000_001];
    private final int START;
    private final int END;

    static {
        setErathosthenes();
        setPrime();
    }

    // 에라토스테네스의 체를 이용하기, 배수 다 지우기(자기자신 빼고)
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

    private static void setPrime() {
        for (int i = 2; i < ERATHOSTHENES.length; i++) {
            if (ERATHOSTHENES[i] == 0) {
                PRIME.put(i, true);
            }
        }
    }

    PrintPrimeNumber(int start, int end) {
        validateInput(start, end);
        START = start;
        END = end;
    }

    private void validateInput(int start, int end) {
        if (isInValidNumber(start) || isInValidNumber(end) || start > end) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private boolean isInValidNumber(int number) {
        return (number < 1 || number > 1_000_000);
    }

    private boolean isPrimeNumber(int number) {
        return PRIME.containsKey(number);
    }

    public void printResult() {
        for (int i = START; i <= END; i++) {
            if (isPrimeNumber(i)) {
                System.out.println(i);
            }
        }
    }
}
