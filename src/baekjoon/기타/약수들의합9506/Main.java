package baekjoon.기타.약수들의합9506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(bf.readLine());
            if (N == -1) {
                break;
            }

            StringBuilder sb = new StringBuilder();
            answer.append(N)
                    .append(" ");
            sb.append("= 1");
            int sum = 1;
            for (int i = 2; i < N; i++) {
                if (N % i == 0) {
                    sum += i;
                    sb.append(" + ")
                            .append(i);
                }
            }

            if (sum == N) {
                answer.append(sb);
            } else {
                answer.append("is NOT perfect.");
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }
}
