package baekjoon.십사단계_기하1.직각삼각형4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int count = 0;
            int[] temp = new int[3];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = toInt(st.nextToken());
                if (temp[i] == 0) {
                    count++;
                }
            }
            if (count == 3) {
                break;
            }
            Arrays.sort(temp);
            if (isRightTriangle(temp[2], temp[0], temp[1])) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static boolean isRightTriangle(int max, int x, int y) {
        return (Math.pow(max, 2) == (Math.pow(x, 2) + Math.pow(y, 2)));
    }
}
