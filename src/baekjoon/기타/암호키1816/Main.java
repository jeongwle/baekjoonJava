package baekjoon.기타.암호키1816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final int[] ERATOSTHENES = new int[1_000_001];

    static {
        ERATOSTHENES[1] = 1;
        for (int i = 2; i < ERATOSTHENES.length; i++) {
            if (ERATOSTHENES[i] == 1) {
                continue;
            }
            for (int j = i * 2; j < ERATOSTHENES.length ; j += i) {
                ERATOSTHENES[j] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long input = Long.parseLong(bf.readLine());

            int number = 2;
            Map<Integer, Integer> check = new HashMap<>();
            while (number < ERATOSTHENES.length && number <= input) {
                if (ERATOSTHENES[number] == 1) {
                    number++;
                    continue;
                }
                if (input % number == 0) {
                    input /= number;
                    if (check.containsKey(number)) {
                        check.put(number, check.get(number) + 1);
                    } else {
                        check.put(number, 1);
                    }
                } else {
                    number++;
                }
            }

            double target = Math.pow(10, 6);
            boolean ok = true;
            for (Integer key : check.keySet()) {
                if (Math.pow(key, check.get(key)) <= target) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}
