package baekjoon.기타.쉽게푸는문제1292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] arr = new int[1_001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int index = 0;
        for (int i = 0; index < 1000; i++) {
            int number = i + 1;
            for (int j = 0; j < number; j++) {
                arr[index] = number;
                index++;
                if (index == 1000) {
                    break;
                }
            }
        }
        System.out.println(getSum(start - 1, end - 1));
    }

    public static int getSum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
