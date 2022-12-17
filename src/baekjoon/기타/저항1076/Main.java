package baekjoon.기타.저항1076;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);

        String first = bf.readLine();
        String second = bf.readLine();
        String third = bf.readLine();

        StringBuilder sb = new StringBuilder();

        if (!first.equals("black")) {
            sb.append(map.get(first));
        }
        sb.append(map.get(second));
        if (sb.charAt(0) != '0') {
            for (int i = 0; i < map.get(third); i++) {
                sb.append("0");
            }
        }
        System.out.println(sb);
    }
}
