package baekjoon.기타.자기복제수2028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCase = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCase; i++) {
            if (isYes(Integer.parseInt(bf.readLine()))) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static boolean isYes(int number) {
        int length = String.valueOf(number).length();
        StringBuilder sb = new StringBuilder();
        sb.append((int)Math.pow(number, 2));
        sb.delete(0, sb.length() - length);
        return (sb.toString().equals(String.valueOf(number)));
    }
}
