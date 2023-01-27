package baekjoon.십팔단계_누적합.구간합구하기11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());

        int[] arr = new int[N * N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[N * i + j] = Integer.parseInt(st.nextToken());
            }
        }

        Integer[] sum = new Integer[N * N];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < question; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int startRow = Integer.parseInt(st.nextToken()) - 1;
            int startCol = Integer.parseInt(st.nextToken()) - 1;
            int endRow = Integer.parseInt(st.nextToken()) - 1;
            int endCol = Integer.parseInt(st.nextToken()) - 1;

            int result = 0;
            for (int j = startRow; j <= endRow; j++) {
                int index = N * j + endCol;
                int indexMinus = N * j + startCol - 1;
                if (indexMinus < 0) {
                    result += sum[index];
                    continue;
                }
                result += sum[index] - sum[indexMinus];
            }
            sb.append(result)
                    .append("\n");
        }
        System.out.print(sb);
    }
}
