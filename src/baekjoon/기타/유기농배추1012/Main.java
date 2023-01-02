package baekjoon.기타.유기농배추1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int numberOfCabbages = Integer.parseInt(st.nextToken());

            int[][] field = new int[height][width];
            boolean[][] visit = new boolean[height][width];

            for (int j = 0; j < numberOfCabbages; j++) {
                st = new StringTokenizer(bf.readLine(), " ");
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                field[row][col] = 1;
            }
            int count = 0;

            for (int j = 0; j < field.length; j++) {
                for (int k = 0; k < field[j].length; k++) {
                    if (field[j][k] == 1 && !visit[j][k]) {
                        count++;
                        visit[j][k] = true;
                        check(field, visit, j, k);
                    }
                }
            }
            sb.append(count)
                    .append("\n");
        }
        System.out.print(sb);
    }

    private static void check(int[][] field, boolean[][] visit, int row, int col) {
        // 왼쪽
        if (col - 1 >= 0 && field[row][col - 1] == 1 && !visit[row][col - 1]) {
            visit[row][col - 1] = true;
            check(field, visit, row, col - 1);
        }
        // 오른쪽
        if (col + 1 < visit[row].length && field[row][col + 1] == 1 && !visit[row][col + 1]) {
            visit[row][col + 1] = true;
            check(field, visit, row, col + 1);
        }
        if (row - 1 >= 0 && field[row - 1][col] == 1 && !visit[row - 1][col]) {
            visit[row - 1][col] = true;
            check(field, visit, row - 1, col);
        }
        if (row + 1 < visit.length && field[row + 1][col] == 1 && !visit[row + 1][col]) {
            visit[row + 1][col] = true;
            check(field, visit, row + 1, col);
        }

    }
}
