package baekjoon.단계11_재귀.별찍기2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input = toInt(bf.readLine());
        StarDraw sd = new StarDraw(input);
        sd.printStar();
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class StarDraw {
    private final int LENGTH;
    private final String[][] star;

    public StarDraw(int length) {
        validateLength(length);
        LENGTH = length;
        star = new String[LENGTH + 1][LENGTH + 1];
        initStar();
    }


    public void printStar() {
        fillSpace(LENGTH, LENGTH);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < star.length; i++) {
            for (int j = 1; j < star[i].length; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private void initStar() {
        for (String[] strings : star) {
            Arrays.fill(strings, "*");
        }
    }

    private void validateLength(int length) {
        if (length < 3 || length >= Math.pow(3, 8)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    /**
     *
     * @param length : 현재 재귀함수가 그려야할 정사각형의 변의 길이
     * @param lengthMax : 맨 첫 번째 정사각형의 변의 길이
     */
    private void fillSpace(int length, int lengthMax) {
        if (length == 1) {
            return;
        }
        int start = length / 3 + 1;

        for (int i = start; i < lengthMax; i += length) {
            for (int j = start; j < lengthMax; j += length) {
                chore(i, j, length / 3);
            }
        }

        fillSpace(length / 3, lengthMax);
    }

    /**
     *
     * @param row : 빈칸 정사각형의 행 시작점
     * @param col : 빈칸 정사각형의 열 시작점
     * @param range : 빈칸 정사각형의 변의 길이
     */
    private void chore(int row, int col, int range ) {
        for (int i = row; i < row + range; i++) {
            for (int j = col; j < col + range; j++) {
                star[i][j] = " ";
            }
        }
    }
}
