package baekjoon.오단계_2차원배열.최댓값2566;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[10][10];

        int max = -1;
        int row = -1;
        int col = -1;
        for (int i = 1; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 1; j < 10; j++) {
                arr[i][j] = toInt(st.nextToken());
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println(max);
        System.out.println(row + " " + col);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
