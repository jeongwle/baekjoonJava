package baekjoon.단계22_분할정복.피보나치수11444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    private static final int MOD = 1_000_000_007;
    private static final int matrixSize = 2;
    private static final long[][] squareMatrix = new long[matrixSize][matrixSize];
    private static final long[][] firstMatrix = new long[matrixSize][matrixSize];
    static {
        squareMatrix[0][0] = 2;
        squareMatrix[0][1] = 3;
        squareMatrix[1][0] = 3;
        squareMatrix[1][1] = 5;
        firstMatrix[0][0] = 0;
        firstMatrix[0][1] = 1;
        firstMatrix[1][0] = 1;
        firstMatrix[1][1] = 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        BigInteger N = new BigInteger(bf.readLine());
        BigInteger divideNumber = new BigInteger("4");
        int remainder = Integer.parseInt(N.mod(divideNumber).toString());
        N = N.subtract(new BigInteger(String.valueOf(remainder)));

        long exponent = Long.parseLong(N.divide(divideNumber).toString());
        long[][] result;
        if (exponent == 0) {
            result = firstMatrix;
        } else {
            result = calculateMatrix(firstMatrix, squareMatrix(exponent));
        }

        int count = 0;
        for (long[] row : result) {
            for (long element : row) {
                if (count == remainder) {
                    System.out.println(element % MOD);
                    return;
                }
                count++;
            }
        }
    }

    private static long[][] squareMatrix(long exponent) {
        if (exponent == 1) {
            return squareMatrix;
        }
        long[][] temp = squareMatrix(exponent / 2);
        if (exponent % 2 == 1) {
            return calculateMatrix(calculateMatrix(temp, temp), squareMatrix);
        }
        return calculateMatrix(temp, temp);
    }

    private static long[][] calculateMatrix(long[][] matrixA, long[][] matrixB) {
        long[][] result = new long[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j] % MOD;
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}
