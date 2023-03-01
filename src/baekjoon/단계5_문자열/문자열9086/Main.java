package baekjoon.단계5_문자열.문자열9086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int CASE = Integer.parseInt(bf.readLine());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < CASE; i++) {
            String input = bf.readLine();
            answer.append(input.charAt(0))
                    .append(input.charAt(input.length() - 1))
                    .append("\n");
        }
        System.out.print(answer);
    }
}
