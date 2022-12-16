package baekjoon.기타.나누기1075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int F = Integer.parseInt(bf.readLine());

        find(N, F);
        System.out.println(sb);
    }

    public static void find(int number, int divisor) {
        number -= number % 100;

        while (number % divisor != 0) {
            number++;
        }
        if (number % 100 < 10) {
            sb.append("0");
        }
        sb.append(number % 100);
    }
}
