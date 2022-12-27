package baekjoon.십칠단계_동적계획법1.가장긴바이토닉부분수열11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;
    private static int[][] dp;
    private static final int VALUE = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        dp = new int[N][3];

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][VALUE] = arr[i];
            dp[i][LEFT] = 1;
            dp[i][RIGHT] = 1;
        }
        setDpLeft();
        setDpRight();

        int max = 0;
        for (int[] index : dp) {
            // dp + dp - 1 -> -1을 하는 이유는 왼쪽 오른쪽 모두를 계산하기 편하게 하려고 1로 설정했기 떄문
            max = Math.max(max, index[LEFT] + index[RIGHT] - 1);
        }
        System.out.println(max);
    }

    public static void setDpLeft() {
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (dp[j][VALUE] < dp[i][VALUE]) {
                    max = Math.max(max, dp[j][LEFT]);
                }
            }
            dp[i][LEFT] += max;
        }
    }

    public static void setDpRight() {
        for (int i = dp.length - 2; i >= 0; i--) {
            int max = 0;
            for (int j = dp.length - 1; j > i; j--) {
                if (dp[j][VALUE] < dp[i][VALUE]) {
                    max = Math.max(max, dp[j][RIGHT]);
                }
            }
            dp[i][RIGHT] += max;
        }
    }
}
