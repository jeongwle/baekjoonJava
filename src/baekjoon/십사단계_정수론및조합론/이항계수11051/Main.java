package baekjoon.십사단계_정수론및조합론.이항계수11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = toInt(st.nextToken());
        int K = toInt(st.nextToken());

        if (N == K) {
            System.out.println(1);
            return;
        }

        HashMap<Integer, Integer> numerator = new HashMap<>(); // 분자
        HashMap<Integer, Integer> denominator = new HashMap<>(); // 분모

        if ((N - K) >= K) {
            for (int i = N - K + 1; i <= N; i++) {
                numerator.put(i, i);
            }
            for (int i = 2; i <= K; i++) {
                denominator.put(i, i);
            }
        } else {
            for (int i = K + 1; i <= N; i++) {
                numerator.put(i, i);
            }
            for (int i = 2; i <= N - K; i++) {
                denominator.put(i, i);
            }
        }

        while (denominator.size() != 0) {
            Integer[] denoKeys = new Integer[denominator.size()];
            denominator.keySet().toArray(denoKeys);
            for (Integer denoKey : denoKeys) {
                int temp = denominator.get(denoKey);
                for (Integer key : numerator.keySet()) {
                    int numerValue = numerator.get(key);
                    for (int i = 2; i <= temp; i++) {
                        if (numerValue % i == 0 && temp % i == 0) {
                            temp /= i;
                            numerValue /= i;
                            numerator.put(key, numerValue);
                            denominator.put(denoKey, temp);
                            i = 2;
                        }
                    }
                    if (temp == 1) {
                        denominator.remove(denoKey);
                        break;
                    }
                }
            }
        }

        int result = 1;
        for (Integer numerValue : numerator.values()) {
            result *= numerValue;
            if (result >= 10007) {
                result %= 10007;
            }
        }
        System.out.println(result);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
