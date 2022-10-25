package baekjoon.십오단계_정수론및조합론.링3036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int CASE = toInt(bf.readLine());
        int[] numbers = new int[CASE - 1];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int first = toInt(st.nextToken());
        for (int i = 0; i < CASE - 1; i++) {
            numbers[i] = toInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CASE - 1; i++) {
            int gcd = getGcd(first, numbers[i]);
            sb.append(first / gcd)
                    .append("/")
                    .append(numbers[i] / gcd)
                    .append("\n");
        }
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static int getGcd(int num1, int num2) {
        HashMap<Integer, Integer> num1Res = new HashMap<>();
        HashMap<Integer, Integer> num2Res = new HashMap<>();

        primeFactorization(num1Res, num1);
        primeFactorization(num2Res, num2);

        Set<Integer> keys = new HashSet<>(num1Res.keySet());
        keys.retainAll(num2Res.keySet());

        int gcd = 1;
        for (Integer key : keys) {
            gcd *= pow(key, min(num1Res.get(key), num2Res.get(key)));
        }

        return gcd;
    }

    public static void primeFactorization(HashMap<Integer, Integer> res, int number) {
        if (number == 1) {
            return;
        }
        int temp = 0;
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                temp = i;
                break;
            }
        }
        if (temp != 0) {
            primeFactorization(res, number / temp);
        }
        if (res.containsKey(temp)) {
            res.put(temp, res.get(temp) + 1);
        } else {
            res.put(temp, 1);
        }

    }
}
