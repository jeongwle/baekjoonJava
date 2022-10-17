package baekjoon.십삼단계_기하1.십사단계_정수론및조합론.배수와약수5086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int num1 = toInt(st.nextToken());
            int num2 = toInt(st.nextToken());

            if (num1 == 0 && num2 == 0) {
                break;
            }

            if (num2 % num1 == 0) {
                sb.append("factor")
                        .append("\n");
            } else if (num1 % num2 == 0) {
                sb.append("multiple")
                        .append("\n");
            } else {
                sb.append("neither")
                        .append("\n");
            }
        }
        System.out.print(sb);

    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
