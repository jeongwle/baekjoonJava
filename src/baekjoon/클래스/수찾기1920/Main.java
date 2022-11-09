package baekjoon.클래스.수찾기1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        bf.readLine();
        Set<Integer> numbers = new HashSet<>();
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        while (st.hasMoreTokens()) {
            int number = toInt(st.nextToken());
            numbers.add(number);
        }

        bf.readLine();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(bf.readLine(), " ");
        while (st.hasMoreTokens()) {
            int number = toInt(st.nextToken());
            if (numbers.contains(number)) {
                sb.append("1")
                        .append("\n");
                continue;
            }
            sb.append("0")
                    .append("\n");
        }
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
