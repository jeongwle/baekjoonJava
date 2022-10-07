package baekjoon.십이단계_집합과맵.듣보잡1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int numOfHear = toInt(st.nextToken());
        int numOfSee = toInt(st.nextToken());
        Set<String> hear = new HashSet<>();
        for (int i = 0; i < numOfHear; i++) {
            hear.add(bf.readLine());
        }

        Set<String> see = new HashSet<>();
        for (int i = 0; i < numOfSee; i++) {
            see.add(bf.readLine());
        }

        hear.retainAll(see);
        StringBuilder sb = new StringBuilder();
        String[] result = new String[hear.size()];
        hear.toArray(result);
        Arrays.sort(result);

        sb.append(hear.size())
                .append("\n");
        for (String res : result) {
            sb.append(res)
                    .append("\n");
        }

        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
