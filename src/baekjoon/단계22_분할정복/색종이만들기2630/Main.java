package baekjoon.단계22_분할정복.색종이만들기2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int WHITE = 0;
    private static final int BLUE = 1;
    private static int[][] colorPaper;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bf.readLine());
        colorPaper = new int[size][size];
        int[] answer = new int[2];

        for (int i = 0; i < colorPaper.length; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < colorPaper[i].length; j++) {
                colorPaper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int firstColor = colorPaper[0][0];
        boolean oneColor = true;
        loop : for (int[] paper : colorPaper) {
            for (int color : paper) {
                if (firstColor != color) {
                    oneColor = false;
                    break loop;
                }
            }
        }
        if (oneColor) {
            answer[firstColor]++;
            System.out.println(answer[WHITE]);
            System.out.println(answer[BLUE]);
            return;
        }

        divide(size, answer, 0, 0);
        System.out.println(answer[WHITE]);
        System.out.println(answer[BLUE]);
    }

    private static void divide(int size, int[] answer, int rowStart, int colStart) {
        int mid = size / 2;

        checkColor(rowStart, colStart, mid, answer);
        checkColor(rowStart, colStart + mid, mid, answer);
        checkColor(rowStart + mid, colStart, mid, answer);
        checkColor(rowStart + mid, colStart + mid, mid, answer);

    }

    private static void checkColor(int rowStart, int colStart, int size, int[] answer) {

        int firstColor = colorPaper[rowStart][colStart];
        for (int i = rowStart; i < rowStart + size; i++) {
            for (int j = colStart; j < colStart + size; j++) {
                if (colorPaper[i][j] != firstColor) {
                    divide(size, answer, rowStart, colStart);
                    return;
                }
            }
        }
        answer[firstColor]++;
    }
}
