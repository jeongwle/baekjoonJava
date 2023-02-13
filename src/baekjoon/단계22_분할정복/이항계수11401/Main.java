package baekjoon.단계22_분할정복.이항계수11401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long factorialN = 1;
        for (int i = 1; i <= N; i++) {
            factorialN *= i;
            factorialN %= MOD;
        }

        long factorialK = 1;
        for (int i = 1; i <= K; i++) {
            factorialK *= i;
            factorialK %= MOD;
        }

        for (int i = 1; i <= N - K; i++) {
            factorialK *= i;
            factorialK %= MOD;
        }
        System.out.println((factorialN * modInverse(factorialK, MOD - 2)) % MOD);
    }

    private static long modInverse(long K, int exponent) {
        if (exponent == 1) {
            return K % MOD;
        }

        long temp = modInverse(K, exponent / 2);
        if (exponent % 2 == 1) {
            return (temp * temp % MOD) * K % MOD;
        }
        return temp * temp % MOD;
    }
}
