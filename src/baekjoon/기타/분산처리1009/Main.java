package baekjoon.기타.분산처리1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int CASE = toInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CASE; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int number = toInt(st.nextToken());
            int repeat = toInt(st.nextToken());
            int result = number % 10; // 1번 한거임
            for (int j = 1; j < repeat; j++) {
                result *= number;
                if (result > 10) {
                    result %= 10;
                }
            }
            if (result == 0) {
                result = 10;
            }
            sb.append(result)
                    .append("\n");
        }
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

}
