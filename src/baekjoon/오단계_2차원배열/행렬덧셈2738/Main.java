package baekjoon.오단계_2차원배열.행렬덧셈2738;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = toInt(st.nextToken());
        int M = toInt(st.nextToken());

        int[][] arr = new int[N][M];
        int count = 0;
        while (count < 2) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    arr[i][j] += toInt(st.nextToken());
                }
            }
            count++;
        }

        StringBuilder sb = new StringBuilder();
        for (int[] ar : arr) {
            for (int val : ar) {
                sb.append(val)
                        .append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
