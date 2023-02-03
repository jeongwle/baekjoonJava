package baekjoon.단계21_큐와덱.요세푸스문제11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = toInt(st.nextToken());
        int targetIndex = toInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 1;
        while (!q.isEmpty()) {
            if (index == targetIndex) {
                sb.append(q.poll());
                if (!q.isEmpty()) {
                    sb.append(", ");
                }
                index = 1;
                continue;
            } else {
                q.add(q.poll());
            }
            index++;
        }
        sb.append(">");
        System.out.println(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
