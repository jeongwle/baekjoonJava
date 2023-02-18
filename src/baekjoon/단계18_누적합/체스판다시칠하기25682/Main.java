package baekjoon.단계18_누적합.체스판다시칠하기25682;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int BLACK = 0;
    private static final int WHITE = 1;
    private static int[][] chessboard;
    private static int[][] blackBoard;
    private static int[][] whiteBoard;
    private static int[] blackSum;
    private static int[] whiteSum;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        chessboard = new int[height][width];
        blackBoard = new int[height][width];
        whiteBoard = new int[height][width];
        for (int i = 0; i < chessboard.length; i++) {
            String input = bf.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'B') {
                    chessboard[i][j] = BLACK;
                    continue;
                }
                chessboard[i][j] = WHITE;
            }
        }
        setBoard();
        whiteSum = new int[height * width];
        blackSum = new int[height * width];
        setSum();
        System.out.println(Math.min(getSum(blackSum, K), getSum(whiteSum, K)));
    }

    private static int getSum(int[] sum, int K) {
        int min = Integer.MAX_VALUE;
        for (int row = 0; row <= chessboard.length - K; row++) {
            for (int col = 0; col <= chessboard[row].length - K; col++) {
                int minCandidate = 0;
                for (int k = 0; k < K; k++) {
                    int plusIndex = (K - 1 + col) + (k + row) * (chessboard[row].length);
                    minCandidate += sum[plusIndex];
                    int minusIndex = plusIndex - K;
                    if (minusIndex < 0) {
                        continue;
                    }
                    minCandidate -= sum[minusIndex];
                }
                min = Math.min(min, minCandidate);
            }
        }
        return min;
    }

    private static void setSum() {
        setValue(blackSum, blackBoard);
        setValue(whiteSum, whiteBoard);
    }

    private static void setValue(int[] sum, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int index = i * board[i].length + j;
                if (index != 0) {
                    sum[index] += sum[index - 1];
                }
                if (board[i][j] != chessboard[i][j]) {
                    sum[i * board[i].length + j]++;
                }
            }
        }
    }

    private static void setBoard() {
        setColor(blackBoard, BLACK, WHITE);
        setColor(whiteBoard, WHITE, BLACK);
    }

    private static void setColor(int[][] board, int colorOne, int colorTwo) {
        for (int i = 0; i < board.length; i++) {
            if (i % 2 == 0) {
                board[i][0] = colorOne;
                continue;
            }
            board[i][0] = colorTwo;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j - 1] == BLACK) {
                    board[i][j] = WHITE;
                }
            }
        }
    }
}
