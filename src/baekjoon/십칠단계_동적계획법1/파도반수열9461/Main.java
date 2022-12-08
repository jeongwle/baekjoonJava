package baekjoon.십칠단계_동적계획법1.파도반수열9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int CASE = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CASE; i++) {
            int number = Integer.parseInt(bf.readLine());
            sb.append(padovanSequence(number))
                    .append("\n");
        }
        System.out.print(sb);
    }

    public static long padovanSequence(int n) {
        long[] padovan = new long[101];
        padovan[1] = padovan[2] = padovan[3] = 1;
        padovan[4] = padovan[5] = 2;
        for (int i = 6; i <= n; i++) {
            padovan[i] = padovan[i - 1] + padovan[i - 5];
        }
        return padovan[n];
    }
}
