package baekjoon.기타.Pyramids5341;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        while (true) {
            int input = Integer.parseInt(bf.readLine());

            if (input == 0) {
                break;
            }

            int blocks = 0;
            for (int i = 1; i <= input; i++) {
                blocks += i;
            }
            answer.append(blocks)
                    .append("\n");
        }
        System.out.print(answer);
    }
}
