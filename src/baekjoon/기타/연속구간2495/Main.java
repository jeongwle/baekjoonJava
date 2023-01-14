package baekjoon.기타.연속구간2495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int result = 1;
            String input = bf.readLine();

            char tmp;
            for (int j = 0; j < input.length(); j++) {
                tmp = input.charAt(j);
                int count = 0;
                while (j < input.length() && input.charAt(j) == tmp) {
                    j++;
                    count++;
                }
                j -= 1;
                result = Math.max(result, count);
            }
            sb.append(result)
                    .append("\n");
        }
        System.out.println(sb);
    }
}
