package baekjoon.단계22_분할정복.행렬제곱10830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int matrixSize = Integer.parseInt(st.nextToken());
        long exponent = Long.parseLong(st.nextToken());
        long[][] matrix = new long[matrixSize][matrixSize];

        for (int i = 0; i < matrix.length; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] result = squareMatrix(matrix, exponent);
        StringBuilder sb = new StringBuilder();
        for (long[] row : result) {
            sb.append(row[0] % MOD);
            for (int i = 1; i < row.length; i++) {
                sb.append(" ")
                        .append(row[i] % MOD);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static long[][] squareMatrix(long[][] matrix, long exponent) {
        if (exponent == 1) {
            return matrix;
        }
        long[][] temp = squareMatrix(matrix, exponent / 2);
        if (exponent % 2 == 1) {
            return calculateMatrix(calculateMatrix(temp, temp), matrix);
        }
        return calculateMatrix(temp, temp);
    }

    private static long[][] calculateMatrix(long[][] matrixA, long[][] matrixB) {
        int size = matrixA.length;
        long[][] result = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += (matrixA[i][k] % MOD) * (matrixB[k][j] % MOD);
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}
