package baekjoon.단계21_큐와덱.프린터큐1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int CASE = toInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CASE; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int numberOfnum = toInt(st.nextToken());
            int position = toInt(st.nextToken());
            Queue<List<Integer>> q = new LinkedList<>();
            st = new StringTokenizer(bf.readLine(), " ");
            int target = 0;
            List<Integer> list = new ArrayList<>();
            for (int index = 0; index < numberOfnum; index++) {
                if (index == position) {
                    target = toInt(st.nextToken());
                    List<Integer> l = new ArrayList<>();
                    list.add(target);
                    l.add(target);
                    l.add(1);
                    q.add(l);
                } else {
                    int number = toInt(st.nextToken());
                    List<Integer> l = new ArrayList<>();
                    list.add(number);
                    l.add(number);
                    l.add(0);
                    q.add(l);
                }
            }

            list.sort(Collections.reverseOrder());
            int count = 0;

            while (!list.isEmpty() && !q.isEmpty()) {
                Integer currentTarget = list.remove(0);
                while (!Objects.equals(Objects.requireNonNull(q.peek()).get(0), currentTarget)) {
                    q.add(q.poll());
                }
                List<Integer> poll = q.poll();
                count++;
                if (currentTarget.equals(target) && poll.get(1) == 1) {
                    sb.append(count)
                            .append("\n");
                    break;
                }

            }
        }
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

}
