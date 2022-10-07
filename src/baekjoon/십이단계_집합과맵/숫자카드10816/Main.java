package baekjoon.십이단계_집합과맵.숫자카드10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> cards = new HashMap<>();

        bf.readLine();
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int number;
        while (st.hasMoreTokens()) {
            number = toInt(st.nextToken());
            if (cards.containsKey(number)) {
                cards.put(number, cards.get(number) + 1);
            } else {
                cards.put(number, 1);
            }
        }

        bf.readLine();
        st = new StringTokenizer(bf.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            number = toInt(st.nextToken());
            if (cards.containsKey(number)) {
                sb.append(cards.get(number));
            } else {
                sb.append(0);
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
