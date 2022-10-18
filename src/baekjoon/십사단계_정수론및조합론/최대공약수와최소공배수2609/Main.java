package baekjoon.십사단계_정수론및조합론.최대공약수와최소공배수2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int num1 = toInt(st.nextToken());
        int num2 = toInt(st.nextToken());

        HashMap<Integer, Integer> num1Res = new HashMap<>();
        HashMap<Integer, Integer> num2Res = new HashMap<>();

        primeFactorization(num1Res, num1);
        primeFactorization(num2Res, num2);

        Set<Integer> res1Key = num1Res.keySet();
        Set<Integer> res2Key = num2Res.keySet();

        Set<Integer> keys = new HashSet<>(res1Key);
        keys.removeAll(res2Key);
        keys.addAll(res2Key);

        int gcd = 1;
        int lcm = 1;
        for (Integer key : keys) {
            boolean num1Present = num1Res.containsKey(key);
            boolean num2Present = num2Res.containsKey(key);

            Integer num1Value = num1Res.get(key);
            Integer num2Value = num2Res.get(key);

            if (num1Present && num2Present) {
                gcd *= Math.pow(key, Math.min(num1Value, num2Value));
                lcm *= Math.pow(key, Math.max(num1Value, num2Value));
            } else if (num1Present) {
                lcm *= Math.pow(key, num1Value);
            } else {
                lcm *= Math.pow(key, num2Value);
            }
        }

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static void primeFactorization(HashMap<Integer, Integer> res, int number) {
        if (number == 1) {
            return;
        }
        int temp = 0;
        for (int i = 2; i <= number ; i++) {
            if (number % i == 0) {
                temp = i;
                break;
            }
        }
        primeFactorization(res, number / temp);
        if (res.containsKey(temp)) {
            res.put(temp, res.get(temp) + 1);
        } else {
            res.put(temp, 1);
        }
    }
}
