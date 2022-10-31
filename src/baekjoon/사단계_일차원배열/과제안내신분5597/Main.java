package baekjoon.사단계_일차원배열.과제안내신분5597;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[31];
        for (int i = 1; i < 29; i++) {
            int index = toInt(bf.readLine());
            arr[index] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                sb.append(i)
                        .append("\n");
            }
        }
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
