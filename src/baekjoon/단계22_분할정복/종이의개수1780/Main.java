package baekjoon.단계22_분할정복.종이의개수1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bf.readLine());
        paper = new int[size][size];
        for (int i = 0; i < paper.length; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < paper[i].length; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] answer = new int[3];
        checkColor(size, 0, 0, answer);

        for (int color : answer) {
            System.out.println(color);
        }
    }

    private static void divide(int size, int rowStart, int colStart, int[] answer) {
        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = rowStart + i * newSize;
                int col = colStart + j * newSize;
                checkColor(newSize, row, col, answer);
            }
        }
    }

    private static void checkColor(int size, int rowStart, int colStart, int[] answer) {
        int firstColor = paper[rowStart][colStart];
        for (int i = rowStart; i < rowStart + size; i++) {
            for (int j = colStart; j < colStart + size; j++) {
                if (firstColor != paper[i][j]) {
                    divide(size, rowStart, colStart, answer);
                    return;
                }
            }
        }
        firstColor++;
        answer[firstColor]++;
    }
}
