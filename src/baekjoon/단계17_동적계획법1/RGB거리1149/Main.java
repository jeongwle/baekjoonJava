package baekjoon.단계17_동적계획법1.RGB거리1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;
    private static int[][] homeColor;
    private static int[][] dp;
//    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        homeColor = new int[N][3];
        dp = new int[N][3];
//        boolean[][] visit = new boolean[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            homeColor[i][RED] = Integer.parseInt(st.nextToken());
            homeColor[i][GREEN] = Integer.parseInt(st.nextToken());
            homeColor[i][BLUE] = Integer.parseInt(st.nextToken());
        }
        dp[0][RED] = homeColor[0][RED];
        dp[0][GREEN] = homeColor[0][GREEN];
        dp[0][BLUE] = homeColor[0][BLUE];

        System.out.println(Math.min(findMin(N - 1, RED),
                Math.min(findMin(N - 1, GREEN), findMin(N - 1, BLUE))));
//        findMin(RED);
//        findMin(0, visit, 0);
//        System.out.println(MIN);
    }

//    public static void findMin(int color) {
//        if (color == 3) {
//            return;
//        }
//        int time = 0;
//        int colorTemp = -1;
//        for (int i = 0; i < homeColor.length; i++) {
//            if (i == 0) {
//                time += homeColor[i][color];
//                colorTemp = color;
//                continue;
//            }
//            if (colorTemp == RED) {
//                if (homeColor[i][GREEN] < homeColor[i][BLUE]) {
//                    time += homeColor[i][GREEN];
//                    colorTemp = GREEN;
//                } else {
//                    time += homeColor[i][BLUE];
//                    colorTemp = BLUE;
//                }
//            } else if (colorTemp == GREEN) {
//                if (homeColor[i][RED] < homeColor[i][BLUE]) {
//                    time += homeColor[i][RED];
//                    colorTemp = RED;
//                } else {
//                    time += homeColor[i][BLUE];
//                    colorTemp = BLUE;
//                }
//            } else {
//                if (homeColor[i][RED] < homeColor[i][GREEN]) {
//                    time += homeColor[i][RED];
//                    colorTemp = RED;
//                } else {
//                    time += homeColor[i][GREEN];
//                    colorTemp = GREEN;
//                }
//            }
//        }
//        System.out.println("color = " + color);
//        System.out.println("time = " + time);
//        System.out.println();
//        MIN = Math.min(time, MIN);
//        findMin(color + 1);
//    }

//    public static void findMin(int depth, boolean[][] visit, int time) {
//        if (depth == homeColor.length) {
//            System.out.println("time = " + time);
//            MIN = Math.min(MIN, time);
//            return;
//        }
//        for (int i = depth; i < homeColor.length; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (!visit[i][j]) {
//                    System.out.println("i = " + i);
//                    System.out.println("j = " + j);
//                    System.out.println();
//                    time += homeColor[i][j];
//                    if (i < homeColor.length - 1) {
//                        visit[i + 1][j] = true;
//                    }
//                    findMin(depth + 1, visit, time);
//                    if (i < homeColor.length - 1) {
//                        visit[i + 1][j] = false;
//                    }
//                    time -= homeColor[i][j];
//                    break;
//                }
//            }
//        }
//    }

    // 시간 초과
//    public static void findMin(int depth, boolean[][] visit, int time) {
//        if (depth == homeColor.length) {
//            MIN = Math.min((time), MIN);
//            return;
//        }
//
//        for (int i = 0; i < 3; i++) {
//            if (!visit[depth][i]) {
//                time += homeColor[depth][i];
//                if (time >= MIN) {
//                    time -= homeColor[depth][i];
//                    continue;
//                }
//                if (depth < homeColor.length - 1) {
//                    visit[depth + 1][i] = true;
//                }
//                findMin(depth + 1, visit, time);
//                if (depth < homeColor.length - 1) {
//                    visit[depth + 1][i] = false;
//                }
//                time -= homeColor[depth][i];
//            }
//        }
//    }


    public static int findMin(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == RED) {
                dp[n][RED] =
                        Math.min(findMin(n - 1, GREEN), findMin(n - 1, BLUE)) + homeColor[n][RED];
            } else if (color == GREEN) {
                dp[n][GREEN] =
                        Math.min(findMin(n - 1, RED), findMin(n - 1, BLUE)) + homeColor[n][GREEN];
            } else if (color == BLUE) {
                dp[n][BLUE] =
                        Math.min(findMin(n - 1, RED), findMin(n - 1, GREEN)) + homeColor[n][BLUE];
            }
        }
        return dp[n][color];
    }
}
