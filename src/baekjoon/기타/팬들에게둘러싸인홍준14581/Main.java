package baekjoon.기타.팬들에게둘러싸인홍준14581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        answer.append(":fan:".repeat(3))
                .append("\n")
                .append(":fan:")
                .append(":")
                .append(bf.readLine())
                .append(":")
                .append(":fan:")
                .append("\n")
                .append(":fan:".repeat(3));
        System.out.println(answer);

    }
}
