package baekjoon.단계17_동적계획법1.가장긴증가하는부분수열11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;
    private static Integer[][] dp;

    private static final int VALUE = 0;
    private static final int COUNT = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        dp = new Integer[N][2];

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 각각의 숫자는 가장 긴 증가하는 부분수열에서 1개 크기의 부분수열이다.
        for (int i = 0; i < dp.length; i++) {
            dp[i][COUNT] = 1;
        }
        setDp();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, dp[i][COUNT]);
        }
        System.out.println(max);
    }

    // 맨 뒤에서 부터 탐색을 시작하고 다시 for문을 현재 인덱스부터 돌려서 value가 작은 것중에 최대값을 찾아 계속 더하면 최대값을 갱신할 수 있다.
    public static void setDp() {
        for (int i = arr.length - 1; i >= 0; i--) {
            dp[i][VALUE] = arr[i];
            if (i != arr.length - 1) {
                // count는 전부 1로 초기화 되어있기 때문에 max를 0으로 해도 상관없음.
                int max = 0;
                for (int j = i; j < arr.length; j++) {
                    if (dp[i][VALUE] < dp[j][VALUE]) {
                        max = Math.max(dp[j][COUNT], max);
                    }
                }
                dp[i][COUNT] += max;
            }
        }
    }
}
