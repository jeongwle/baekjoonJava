package baekjoon.클래스.큐10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int CASE = toInt(bf.readLine());
        LinkedList<Integer> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CASE; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            String input = st.nextToken();
            switch (input) {
                case "push":
                    int number = toInt(st.nextToken());
                    q.offer(number);
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(q.poll());
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(q.size())
                            .append("\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case "front":
                    if (q.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(q.peekFirst());
                    }
                    sb.append("\n");
                    break;
                case "back":
                    if (q.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(q.peekLast());
                    }
                    sb.append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

}
