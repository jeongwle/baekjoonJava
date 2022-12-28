package baekjoon.기타.부호1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(bf.readLine());

            BigInteger result = new BigInteger("0");
            for (int j = 0; j < N; j++) {
                result = result.add(new BigInteger(bf.readLine()));
            }
            if (result.signum() < 0) {
                System.out.println("-");
            } else if (result.signum() > 0) {
                System.out.println("+");
            } else {
                System.out.println("0");
            }

        }
    }
}
