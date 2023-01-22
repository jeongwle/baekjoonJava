package baekjoon.기타.모음의개수1264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = bf.readLine();
            if (input.equals("#")) {
                break;
            }

            int count = 0;
            for (char c : input.toCharArray()) {
                char lower = Character.toLowerCase(c);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    count++;
                }
            }
            sb.append(count)
                    .append("\n");
        }
        System.out.print(sb);
    }
}
