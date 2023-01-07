package baekjoon.기타.럭비클럽2083;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = bf.readLine();
            if (input.equals("# 0 0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(input, " ");
            sb.append(st.nextToken())
                    .append(" ");
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (age > 17 || weight >= 80) {
                sb.append("Senior\n");
            } else {
                sb.append("Junior\n");
            }
        }
        System.out.print(sb);
    }
}
