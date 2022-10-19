package baekjoon.십사단계_정수론및조합론.최소공배수1934;

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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CASE; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int num1 = toInt(st.nextToken());
            int num2 = toInt(st.nextToken());

            HashMap<Integer, Integer> num1Res = new HashMap<>();
            HashMap<Integer, Integer> num2Res = new HashMap<>();

            primeFactorization(num1Res, num1);
            primeFactorization(num2Res, num2);

            sb.append(getLcm(num1Res, num2Res))
                    .append("\n");
        }
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
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
        primeFactorization(res, number / temp);
        if (res.containsKey(temp)) {
            res.put(temp, res.get(temp) + 1);
        } else {
            res.put(temp, 1);
        }
    }

    public static int getLcm(HashMap<Integer, Integer> res1, HashMap<Integer, Integer> res2) {
        int lcm = 1;
        Set<Integer> keys = new HashSet<>(res1.keySet());
        keys.addAll(res2.keySet());

        for (Integer key : keys) {
            boolean res1Present = res1.containsKey(key);
            boolean res2Present = res2.containsKey(key);

            Integer num1Value = res1.get(key);
            Integer num2Value = res2.get(key);

            if (res1Present && res2Present) {
                lcm *= pow(key, max(num1Value, num2Value));
            } else if (res1Present) {
                lcm *= pow(key, num1Value);
            } else {
                lcm *= pow(key, num2Value);
            }
        }
        return lcm;
    }
}
