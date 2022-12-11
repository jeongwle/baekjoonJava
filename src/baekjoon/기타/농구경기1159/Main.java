package baekjoon.기타.농구경기1159;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int CASE = Integer.parseInt(bf.readLine());
        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < CASE; i++) {
            String input = bf.readLine();
            char c = input.charAt(0);

            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        Set<Character> characters = count.keySet();
        StringBuilder sb = new StringBuilder();
        for (char c : characters) {
            if (count.get(c) >= 5) {
                sb.append(c);
            }
        }
        if (sb.length() == 0) {
            sb.append("PREDAJA");
        }
        System.out.println(sb);
    }
}
