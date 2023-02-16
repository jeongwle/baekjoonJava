package baekjoon.단계17_동적계획법1.평범한배낭12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static Integer[][] dp;
    private static int[] weight;
    private static int[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int numberOfThings = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        dp = new Integer[numberOfThings][maxWeight + 1];
        weight = new int[numberOfThings];
        value = new int[numberOfThings];

        for (int i = 0; i < numberOfThings; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dp(numberOfThings - 1, maxWeight));
    }

    private static int dp(int item, int maxWeight) {
        if (item < 0 || maxWeight < 0) {
            return 0;
        }
        if (dp[item][maxWeight] == null) {
            if (weight[item] > maxWeight) {
                dp[item][maxWeight] = dp(item - 1, maxWeight);
            } else {
                dp[item][maxWeight] = Math.max(
                        dp(item - 1, maxWeight - weight[item]) + value[item],
                        dp(item - 1, maxWeight)
                );
            }
        }
        return dp[item][maxWeight];
    }
}
