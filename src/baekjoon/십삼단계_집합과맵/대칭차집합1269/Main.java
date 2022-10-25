package baekjoon.십삼단계_집합과맵.대칭차집합1269;

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

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        Set<String> first = new HashSet<>();
        Set<String> second = new HashSet<>();
        while (st.hasMoreTokens()) {
            first.add(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine(), " ");
        while (st.hasMoreTokens()) {
            second.add(st.nextToken());
        }

        Set<String> temp = new HashSet<>(first);

        first.removeAll(second);
        second.removeAll(temp);
        System.out.println(first.size() + second.size());
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
