package baekjoon.단계4_1차원배열.공넣기10810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] baskets = new int[size];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for (int j = start - 1; j < end; j++) {
                baskets[j] = value;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int element : baskets) {
            sb.append(element)
                    .append(" ");
        }
        System.out.println(sb);
    }
}
