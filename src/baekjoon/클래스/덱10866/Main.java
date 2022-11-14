package baekjoon.클래스.덱10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int CASE = toInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < CASE; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            String input = st.nextToken();
            switch (input) {
                case "push_front":
                    deque.addFirst(toInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(toInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.removeFirst());
                    }
                    sb.append("\n");
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.removeLast());
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(deque.size())
                            .append("\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.getFirst());
                    }
                    sb.append("\n");
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.getLast());
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
