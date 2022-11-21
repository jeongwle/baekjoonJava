package baekjoon.클래스.나무자르기2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = toInt(st.nextToken()); // 나무 개수
        int M = toInt(st.nextToken()); // 필요한 길이

        int[] length = new int[N];
        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < length.length; i++) {
            length[i] = toInt(st.nextToken());
        }
        Arrays.sort(length);
        long min = 0;
        long max = length[length.length - 1];
        max++;

        while (min < max) {
            long mid = (max + min) / 2;

            long sum = 0;

            for (int leng : length) {
                if (leng > mid) {
                    sum += leng - mid;
                }
            }

            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
