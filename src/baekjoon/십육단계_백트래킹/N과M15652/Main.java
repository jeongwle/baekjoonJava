package baekjoon.십육단계_백트래킹.N과M15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = toInt(st.nextToken());
        int M = toInt(st.nextToken());

        arr = new int[M];
        dfs(N, M, 0, 0);
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static void dfs(int N, int M, int depth, int idx) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val)
                        .append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            arr[depth] = i + 1;
            dfs(N, M, depth + 1, i);
        }
    }
}
