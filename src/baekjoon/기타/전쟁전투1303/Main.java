package baekjoon.기타.전쟁전투1303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static String[] battleField;
    private static boolean[][] visit;

    private static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        battleField = new String[height];
        visit = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            battleField[i] = bf.readLine();
        }

        int W = 0;
        int B = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < battleField[i].length(); j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    check(battleField[i].charAt(j), i, j);
                    if (battleField[i].charAt(j) == 'W') {
                        W += Math.pow(count, 2);
                    } else {
                        B += Math.pow(count, 2);
                    }
                    count = 1;
                }
            }
        }
        System.out.println(W + " " + B);
    }

    private static void check(char c, int height, int width) {
        // 왼쪽
        if (width - 1 >= 0 && !visit[height][width - 1]
                && battleField[height].charAt(width - 1) == c) {
            count++;
            visit[height][width - 1] = true;
            check(c, height, width - 1);
        }
        // 오른쪽
        if (width + 1 < battleField[height].length() && !visit[height][width + 1]
                && battleField[height].charAt(width + 1) == c) {
            count++;
            visit[height][width + 1] = true;
            check(c, height, width + 1);
        }
        // 위
        if (height - 1 >= 0 && !visit[height - 1][width]
                && battleField[height - 1].charAt(width) == c) {
            count++;
            visit[height - 1][width] = true;
            check(c, height - 1, width);
        }
        // 아래
        if (height + 1 < battleField.length && !visit[height + 1][width]
                && battleField[height + 1].charAt(width) == c) {
            count++;
            visit[height + 1][width] = true;
            check(c, height + 1, width);
        }
    }
}
