package baekjoon.기본수학1.달팽이는올라가고싶다;
/*
백준 2869 시간초를 위해 짜본 코드
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int CLIMBING_HEIGHT = Integer.parseInt(st.nextToken());
        final int FALLING_HEIGHT = Integer.parseInt(st.nextToken());
        final int TARGET_HEIGHT = Integer.parseInt(st.nextToken());

        int day = (int) Math.ceil(
                (double) (TARGET_HEIGHT - FALLING_HEIGHT) / (CLIMBING_HEIGHT - FALLING_HEIGHT)
        );
        System.out.println(day);
    }
}
