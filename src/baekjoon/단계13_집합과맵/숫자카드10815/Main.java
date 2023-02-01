package baekjoon.단계13_집합과맵.숫자카드10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bf.readLine();

        HashSet<String> cards = new HashSet<>();
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        while (st.hasMoreTokens()) {
            cards.add(st.nextToken());
        }

        bf.readLine();
        st = new StringTokenizer(bf.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            if (cards.contains(st.nextToken())) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append(" ");
        }
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
