package baekjoon.기타.나머지와몫이같은수1834;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        BigInteger result = new BigInteger("0");

        for (int i = 1; i < N; i++) {
            result = result.add(new BigInteger(String.valueOf((long)N * i + i)));
        }
        System.out.println(result);
    }
}
