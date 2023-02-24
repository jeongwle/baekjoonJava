package baekjoon.단계7_2차원배열.색종이2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int CASE = toInt(bf.readLine());
        int[][] arr = new int[101][101];

        for (int i = 0; i < CASE; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int row = toInt(st.nextToken());
            int column = toInt(st.nextToken());

            for (int j = row; j < row + 10; j++) {
                for (int k = column; k < column + 10; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
//        int[][] arr = new int[CASE][2];
//        for (int i = 0; i < CASE; i++) {
//            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
//            arr[i][0] = toInt(st.nextToken());
//            arr[i][1] = toInt(st.nextToken());
//        }
//
//        int sum = 0;
//        for (int i = 0; i < CASE - 1; i++) {
//            for (int j = i + 1; j < CASE; j++) {
//                sum += overlappedArea(arr[i], arr[j]);
//            }
//        }
//
//        System.out.println(CASE * 100 - sum);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

//    public static int overlappedArea(int[] arr1, int[] arr2) {
//        if (Math.abs(arr1[0] - arr2[0]) < 10 && Math.abs(arr1[1] - arr2[1]) < 10) {
//            int width = Math.min(arr1[0], arr2[0]) + 10 - Math.max(arr1[0], arr2[0]);
//            int height = Math.min(arr1[1], arr2[1]) + 10 - Math.max(arr1[1], arr2[1]);
//            return width * height;
//        }
//        return 0;
//    }
}
