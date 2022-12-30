package baekjoon.십칠단계_동적계획법1.포도주시식2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] amountOfWine;
    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        amountOfWine = new int[N];
        dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            amountOfWine[i] = Integer.parseInt(bf.readLine());
        }

        if (N >= 1) {
            dp[0] = amountOfWine[0];
        }
        if (N >= 2) {
            dp[1] = amountOfWine[0] + amountOfWine[1];
        }
        if (N >= 3) {
            dp[2] = Math.max(dp[1],
                    Math.max(amountOfWine[0] + amountOfWine[2], amountOfWine[1] + amountOfWine[2]));
        }
        System.out.println(findMax(N - 1));
    }

    public static int findMax(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(findMax(N - 1), Math.max(findMax(N - 2) + amountOfWine[N],
                    findMax(N - 3) + amountOfWine[N - 1] + amountOfWine[N]));
        }
        return dp[N];
    }
}
