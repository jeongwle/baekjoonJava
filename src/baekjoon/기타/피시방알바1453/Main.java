package baekjoon.기타.피시방알바1453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int people = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        Set<Integer> seat = new HashSet<>();

        while (st.hasMoreTokens()) {
            seat.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(people - seat.size());
    }
}
