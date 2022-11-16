package baekjoon.클래스.랜선자르기1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int CASE = toInt(st.nextToken());
        int TARGET_NUMBER = toInt(st.nextToken());
        int[] numArr = new int[CASE];

        for (int i = 0; i < CASE; i++) {
            numArr[i] = toInt(bf.readLine());
        }
        Arrays.sort(numArr);

        long max = numArr[numArr.length - 1];
        long min = 0;
        long mid;
        max++;

        while (min < max) {
            mid = (max + min) / 2;

            long count = 0;

            for (int num : numArr) {
                count += num / mid;
            }

            if (count < TARGET_NUMBER) {
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
