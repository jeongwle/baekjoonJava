package baekjoon.십이단계_브루트포스.체스판다시칠하기1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int height = toInt(st.nextToken()); // 세로
        int width = toInt(st.nextToken());  // 가로

        String[] board = new String[height];
        for (int i = 0; i < board.length; i++) {
            board[i] = bf.readLine();
        }

        Board bd = new Board(board);
        System.out.println(bd.count());

    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class Board {
    private static final String FIRST_CASE = "BWBWBWBW";
    private static final String SECOND_CASE = "WBWBWBWB";
    private final String[] board;

    Board(String[] board) {
        this.board = board;
    }

    public int count() {
        int result = 100;
        for (int i = 0; i <= board.length - 8; i++) {
            for (int j = 0; j <= board[i].length() - 8; j++) {
                int temp = (Math.min(countCaseOne(i, j), countCaseTwo(i, j)));
                if (temp < result) {
                    result = temp;
                }
            }
        }
        return result;
    }

    private int countCaseOne(int left, int right) {
        int totalCount = 0;
        for (int i = left; i < left + 8; i++) {
            int lineCount = 0;
            for (int j = right; j < right + 8; j++) {
                if (i % 2 == 0 && FIRST_CASE.charAt(j - right) != board[i].charAt(j)) {
                    lineCount++;
                }
                if (i % 2 == 1 && SECOND_CASE.charAt(j - right) != board[i].charAt(j)) {
                    lineCount++;
                }
            }
            totalCount += lineCount;
        }
        return totalCount;
    }

    private int countCaseTwo(int left, int right) {
        int totalCount = 0;
        for (int i = left; i < left + 8; i++) {
            int lineCount = 0;
            for (int j = right; j < right + 8; j++) {
                if (i % 2 == 0 && SECOND_CASE.charAt(j - right) != board[i].charAt(j)) {
                    lineCount++;
                }
                if (i % 2 == 1 && FIRST_CASE.charAt(j - right) != board[i].charAt(j)) {
                    lineCount++;
                }
            }
            totalCount += lineCount;
        }
        return totalCount;
    }
}
