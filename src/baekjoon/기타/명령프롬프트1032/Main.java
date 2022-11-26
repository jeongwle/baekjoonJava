package baekjoon.기타.명령프롬프트1032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            if (i == 0) {
                sb.append(input);
                continue;
            }

            for (int j = 0; j < input.length(); j++) {
                if (sb.charAt(j) != input.charAt(j)) {
                    sb.replace(j, j + 1, "?");
                }
            }
        }
        System.out.println(sb);
    }
}
