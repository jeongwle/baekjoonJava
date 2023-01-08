package baekjoon.십팔단계_누적합.수열2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int repeat = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sum = new int[N - repeat + 1];

        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < repeat; i++) {
            sum[0] += arr[i];
        }

        max = sum[0];

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] - arr[i - 1] + arr[i + repeat - 1];
            max = Math.max(max, sum[i]);
        }
        System.out.println(max);
    }
}
