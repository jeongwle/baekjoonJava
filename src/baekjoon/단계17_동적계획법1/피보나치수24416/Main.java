package baekjoon.단계17_동적계획법1.피보나치수24416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int recursiveCount = 0;
    private static int dynamicCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        recursiveFibonacci(N);
        dynamicFibonacci(N);
        System.out.print(recursiveCount);
        System.out.print(" ");
        System.out.println(dynamicCount);
    }

    public static int recursiveFibonacci(int n) {
        if (n == 1 || n == 2) {
            recursiveCount++;
            return 1;
        }
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static int dynamicFibonacci(int n) {
        int[] f = new int[41];
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            dynamicCount++;
        }
        return f[n];
    }
}
