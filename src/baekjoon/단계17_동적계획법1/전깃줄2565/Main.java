package baekjoon.단계17_동적계획법1.전깃줄2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfWire = Integer.parseInt(bf.readLine());
        int[][] wires = new int[numberOfWire][2];

        for (int i = 0; i < wires.length; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            wires[i][LEFT] = Integer.parseInt(st.nextToken());
            wires[i][RIGHT] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wires, Comparator.comparingInt(o -> o[LEFT]));

        Integer[] dp = new Integer[numberOfWire];

        for (int i = wires.length - 1; i >= 0; i--) {
            dp[i] = 1;
            if (i != wires.length - 1) {
                int max = 0;
                for (int j = i; j < wires.length ; j++) {
                    if (wires[i][RIGHT] < wires[j][RIGHT]) {
                        max = Math.max(dp[j], max);
                    }
                }
                dp[i] += max;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int count : dp) {
            max = Math.max(count, max);
        }
        System.out.println(numberOfWire - max);
    }
}
