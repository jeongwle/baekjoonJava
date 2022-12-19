package baekjoon.십칠단계_동적계획법1.계단오르기2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] stairs;
    private static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        stairs = new int[N];
        dp = new Integer[N][3];
        // 역순으로 받아서 0번쨰를 항상 밟도록
        for (int i = stairs.length - 1; i >= 0; i--) {
            stairs[i] = Integer.parseInt(bf.readLine());
        }

        System.out.println(recur(0, 0));
    }

    public static int recur(int index, int count) {
        if (index >= stairs.length) {
            return 0;
        }
        if (dp[index][count] == null) {
            // 계단을 세개 연속으로 밟지 않는다.
            if (count == 2) {
                dp[index][count] = recur(index + 1, 0);
            } else {
                dp[index][count] =
                        Math.max(recur(index + 1, count + 1), recur(index + 2, 0)) + stairs[index];
            }
        }
        return dp[index][count];
    }
}
