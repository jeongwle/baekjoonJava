package baekjoon.십삼단계_기하1.직사각형에서탈출1085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int LEFT = toInt(st.nextToken());
        int BOTTOM = toInt(st.nextToken());
        int width = toInt(st.nextToken());
        int height = toInt(st.nextToken());
        int TOP = height - BOTTOM;
        int RIGHT = width - LEFT;

        int min1 = Math.min(LEFT, RIGHT);
        int min2 = Math.min(TOP, BOTTOM);
        System.out.println(Math.min(min1, min2));
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
