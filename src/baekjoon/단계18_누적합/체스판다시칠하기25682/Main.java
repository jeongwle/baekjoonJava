package baekjoon.단계18_누적합.체스판다시칠하기25682;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int BLACK = 0;
    private static final int WHITE = 1;
    private static int[][] chessboard;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        chessboard = new int[height][width];
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
        System.out.println(
                Math.min(getAnswer(BLACK, height, width, K), getAnswer(WHITE, height, width, K)));
    }

    private static int getAnswer(int startColor, int height, int width, int K) {
        int[][] prefixSum = new int[height + 1][width + 1];
        boolean isRightColor;
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                if (startColor == BLACK) {
                    if ((i + j) % 2 == 0) {
                        isRightColor = (chessboard[i][j] == BLACK);
                    } else {
                        isRightColor = (chessboard[i][j] == WHITE);
                    }
                } else {
                    if ((i + j) % 2 == 0) {
                        isRightColor = (chessboard[i][j] == WHITE);
                    } else {
                        isRightColor = (chessboard[i][j] == BLACK);
                    }
                }
                int value = 1;
                if (isRightColor) {
                    value = 0;
                }
                prefixSum[i + 1][j + 1] =
                        prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j] + value;
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= height - K + 1; i++) {
            for (int j = 1; j <= width - K + 1; j++) {
                answer = Math.min(answer,
                        prefixSum[i + K - 1][j + K - 1] - prefixSum[i + K - 1][j - 1] - prefixSum[i
                                - 1][j + K - 1] + prefixSum[i - 1][j - 1]
                );
            }
        }
        return answer;
    }
}
