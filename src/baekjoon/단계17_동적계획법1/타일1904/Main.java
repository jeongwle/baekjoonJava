package baekjoon.단계17_동적계획법1.타일1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        System.out.println(getNumberOfCases(N + 1));
    }

    public static int getNumberOfCases(int n) {
        int[] fibonacci = new int[1_000_002];
        fibonacci[1] = fibonacci[2] = 1;
        for (int i = 3; i <= n; i++) {
            fibonacci[i] = (fibonacci[i - 1] % 15746) + (fibonacci[i - 2] % 15746);
            fibonacci[i] %= 15746;
        }
        return fibonacci[n];
    }
}
