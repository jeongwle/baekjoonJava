package baekjoon.기타.임시반장정하기1268;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        // 입력 담는 2차원 배열
        int[][] studentClass = new int[N][5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < studentClass[i].length; j++) {
                studentClass[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 같은 반 횟수
        int[] numberOfSameClass = new int[N];
        boolean[][] isSameClass = new boolean[N][N];

        for (int i = 0; i < studentClass.length; i++) {
            for (int j = 0; j < studentClass[i].length; j++) {
                int targetClass = studentClass[i][j];
                for (int k = 0; k < studentClass.length; k++) {
                    if (i == k) {
                        continue;
                    }
                    if (targetClass == studentClass[k][j] && !isSameClass[i][k]) {
                        numberOfSameClass[i]++;
                        isSameClass[i][k] = true;
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int result = -1;
        for (int i = 0; i < numberOfSameClass.length; i++) {
            if (max < numberOfSameClass[i]) {
                result = i + 1;
                max = numberOfSameClass[i];
            }
        }
        System.out.println(result);
    }
}
