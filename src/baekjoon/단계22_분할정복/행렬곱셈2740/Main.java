package baekjoon.단계22_분할정복.행렬곱셈2740;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] A;
    private static int[][] B;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        for (int i = 0; i < A.length; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine(), " ");
        st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        B = new int[M][K];
        for (int i = 0; i < B.length; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < B[i].length; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder answer = new StringBuilder();
        setAnswer(answer, N, K, M);
        System.out.print(answer);
    }

    private static void setAnswer(StringBuilder answer, int N, int K, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                answer.append(calculate(i, j, M))
                        .append(" ");
            }
            answer.append("\n");
        }
    }

    private static int calculate(int AIndex, int BIndex, int M) {
        int answer = 0;
        for (int i = 0; i < M; i++) {
            answer += A[AIndex][i] * B[i][BIndex];
        }
        return answer;
    }
}
