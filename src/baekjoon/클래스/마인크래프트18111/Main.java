package baekjoon.클래스.마인크래프트18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int w = toInt(st.nextToken());
        int h = toInt(st.nextToken());
        int block = toInt(st.nextToken());

        int[] arr = new int[w * h];
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = h * i; j < h * (i + 1); j++) {
                arr[j] = toInt(st.nextToken());
            }
        }
        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[arr.length - 1];

        int time = Integer.MAX_VALUE;
        int average = Integer.MIN_VALUE;
        for (int i = min; i <= max; i++) {
            int timeTemp = 0;
            int blockTemp = block;
            for (int element : arr) {
                int diff = i - element;
                if (diff < 0) { // 블럭을 제거해야함
                    timeTemp += Math.abs(diff) * 2;
                } else { // 블럭을 추가해야함
                    timeTemp += diff;
                }
                blockTemp -= diff;
            }

            if (blockTemp >= 0 && time >= timeTemp) {
                time = timeTemp;
                average = i;
            }
        }
        System.out.println(time + " " + average);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

}
