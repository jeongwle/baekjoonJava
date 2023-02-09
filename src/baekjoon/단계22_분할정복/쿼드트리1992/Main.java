package baekjoon.단계22_분할정복.쿼드트리1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] video;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bf.readLine());
        video = new int[size][size];

        for (int i = 0; i < video.length; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), "01", true);
            for (int j = 0; j < video[i].length; j++) {
                video[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder answer = new StringBuilder();
        checkColor(size, 0, 0, answer);
        System.out.println(answer);
    }

    private static void divide(int size, int rowStart, int colStart, StringBuilder answer) {
        answer.append("(");
        int mid = size / 2;
        // [rowStart, colStart], [rowStart, colStart + mid], [rowStart + mid, colStart], [rowStart + mid, colStart + mid]
        checkColor(mid, rowStart, colStart, answer);
        checkColor(mid, rowStart, colStart + mid, answer);
        checkColor(mid, rowStart + mid, colStart, answer);
        checkColor(mid, rowStart + mid, colStart + mid, answer);

        answer.append(")");
    }

    private static void checkColor(int size, int rowStart, int colStart, StringBuilder answer) {
        int firstColor = video[rowStart][colStart];
        for (int i = rowStart; i < rowStart + size; i++) {
            for (int j = colStart; j < colStart + size; j++) {
                if (firstColor != video[i][j]) {
                    divide(size, rowStart, colStart, answer);
                    return;
                }
            }
        }
        answer.append(firstColor);
    }
}
