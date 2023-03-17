package baekjoon.기타.별찍기2443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                answer.append(" ");
            }
            for (int j = 0; j < 2 * (N - i) - 1; j++) {
                answer.append("*");
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }
}
