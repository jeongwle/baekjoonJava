package baekjoon.단계15_정수론및조합론.다리놓기1010;

/*
왼쪽 다리 지을 수 있는 포인트 N
오른쪽 다리 지을 수 있는 포인트 M
N <= M
다리는 서로 겹칠 수 없음. 다리는 N개를 지을거임.
N개의 다리를 지을 수 있는 경우으 수를 구하는 프로그램

N = 1이면 M개
N = 2이면 M = 2이면 1개 1
N = 2이고 M = 3이면 3개 2 + 1
N = 2이고 M = 4이면 6개 3 + 2 + 1
N = 2이고 M = 5이면 10개 4 + 3 + 2 + 1


N = 3이고 M = 3이면 1개
N = 3이고 M = 4이면 (2 + 1) + (1)
                     2/ 3   2/2
N = 3이고 M = 5이면 (3 + 2 + 1) + (2 + 1) + (1)
                     2 /4 경우의수  2/3 경우의수  2/2 경우의수
N = 4이고 M = 4이면 1개
N = 4이고 M = 5이면 5개 (2 + 1 + 1) + 1
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int CASE = toInt(scanner.nextLine());
        int[][] data = new int[31][31];
        // 제일 기초가 되는 N이 1일때의 경우의 수들을 저장
        for (int i = 1; i < 31; i++) {
            data[1][i] = i;
        }

        // N이 2일때 부터의 경우의 수들을 저장
        for (int i = 2; i < 31; i++) {
            for (int j = i; j < 31; j++) {
                int result = 0;
                for (int k = i - 1; k < j; k++) {
                    result += data[i - 1][k];
                }
                data[i][j] = result;
            }
        }

        for (int i = 0; i < CASE; i++) {
            String[] input = mySplit(scanner.nextLine());
            final int LEFT = toInt(input[0]);
            final int RIGHT = toInt(input[1]);
            System.out.println(data[LEFT][RIGHT]);
        }
    }

    private static int toInt(String input) {
        return Integer.parseInt(input);
    }

    private static String[] mySplit(String input) {
        return input.split(" ");
    }
}
