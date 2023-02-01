package baekjoon.단계17_동적계획법1.정수삼각형1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] triangle;
    private static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        triangle = new int[N][];
        dp = new Integer[N][];
        for (int i = 1; i <= N; i++) {
            triangle[i - 1] = new int[i];
            dp[i - 1] = new Integer[i];
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int index = 0;
            while (st.hasMoreTokens()) {
                triangle[i - 1][index] = Integer.parseInt(st.nextToken());
                index++;
            }
        }
        System.out.println(recur(0, 0));
    }

    public static int recur(int depth, int choice) {
        if (depth == triangle.length - 1) {
            return triangle[depth][choice];
        }

        if (dp[depth][choice] == null) {
            dp[depth][choice] = Math.max(recur(depth + 1, choice), recur(depth + 1, choice + 1))
                    + triangle[depth][choice];
        }
        return dp[depth][choice];
    }
}