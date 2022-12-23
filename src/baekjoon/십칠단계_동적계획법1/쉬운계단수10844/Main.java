package baekjoon.십칠단계_동적계획법1.쉬운계단수10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static Integer[][] dp;
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberLength = Integer.parseInt(bf.readLine());
        dp = new Integer[numberLength + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        long result = 0;
        for (int i = 1; i < 10; i++) {
            result += recur(numberLength, i);
        }
        System.out.println(result % MOD);
    }

    public static int recur(int digit, int val) {
        if (digit == 1) {
            return dp[digit][val];
        }
        if (dp[digit][val] == null) {
            if (val == 9) {
                dp[digit][val] = recur(digit - 1, 8) % MOD;
            } else if (val == 0) {
                dp[digit][val] = recur(digit - 1, 1) % MOD;
            } else {
                dp[digit][val] = recur(digit - 1, val + 1) % MOD + recur(digit - 1, val - 1) % MOD;
            }
        }

        return dp[digit][val] % MOD;
    }

}
