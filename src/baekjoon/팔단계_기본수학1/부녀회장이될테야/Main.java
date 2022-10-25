package baekjoon.팔단계_기본수학1.부녀회장이될테야;
/*
백준 2775
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int[][] NUMBER_OF_RESIDENT = new int[15][15];
    static {
        // 0층 i호에는 i명
        for (int i = 0; i < 15; i++) {
            NUMBER_OF_RESIDENT[0][i] = i;
        }
        // 1~15층 1호에는 1명
        for (int i = 1; i < 15; i++) {
            NUMBER_OF_RESIDENT[i][1] = 1;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                NUMBER_OF_RESIDENT[i][j] = NUMBER_OF_RESIDENT[i][j - 1] + NUMBER_OF_RESIDENT[i - 1][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        final int CASE = toInt(bf.readLine());

        for (int i = 0; i < CASE; i++) {
            final int FLOOR = toInt(bf.readLine());
            final int ROOM_NUMBER = toInt(bf.readLine());
            validateInput(FLOOR);
            validateInput(ROOM_NUMBER);
            System.out.println(NUMBER_OF_RESIDENT[FLOOR][ROOM_NUMBER]);
        }

    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static void validateInput(int number) {
        if (number < 1 || number > 14) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }
}
