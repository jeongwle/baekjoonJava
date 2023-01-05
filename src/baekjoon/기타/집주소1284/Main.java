package baekjoon.기타.집주소1284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String N = bf.readLine();
            if (Objects.equals(N, "0")) {
                break;
            }

            // 맨 앞 여백
            int result = 1;
            for (char c : N.toCharArray()) {
                switch (c) {
                    case '0':
                        result += 4;
                        break;
                    case '1':
                        result += 2;
                        break;
                    default:
                        result += 3;
                        break;
                }
                // 사이 여백 및 맨 뒤 여백
                result += 1;
            }
            sb.append(result)
                    .append("\n");
        }
        System.out.print(sb);
    }
}
