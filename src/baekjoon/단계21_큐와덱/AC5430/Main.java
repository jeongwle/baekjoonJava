package baekjoon.단계21_큐와덱.AC5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCase = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        loop : for (int i = 0; i < numberOfCase; i++) {
            String command = bf.readLine();
            int size = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine(), "[,]");
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < size; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean reverse = false;
            for (char c : command.toCharArray()) {
                switch (c) {
                    case 'R':
                        reverse = !reverse;
                        break;
                    case 'D':

                        if (reverse) {
                            if (deque.pollLast() == null) {
                                sb.append("error\n");
                                continue loop;
                            }
                        } else {
                            if (deque.pollFirst() == null) {
                                sb.append("error\n");
                                continue loop;
                            }
                        }
                        break;
                }
            }
            if (deque.size() == 0) {
                sb.append("[]\n");
                continue;
            }
            sb.append("[");
            if (reverse) {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(",")
                            .append(deque.pollLast());
                }
            } else {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(",")
                            .append(deque.pollFirst());
                }
            }
            sb.append("]\n");
        }
        System.out.print(sb);
    }
}
