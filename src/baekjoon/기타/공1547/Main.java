package baekjoon.기타.공1547;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(bf.readLine());

        boolean[] cups = new boolean[4];
        cups[1] = true;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if (cups[first]) {
                cups[first] = false;
                cups[second] = true;
            } else if (cups[second]) {
                cups[second] = false;
                cups[first] = true;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < 4; i++) {
            if (cups[i]) {
                answer.append(i);
                break;
            }
        }

        if (answer.length() == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }
}
