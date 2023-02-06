package baekjoon.단계21_큐와덱.회전하는큐1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> circularQueue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            circularQueue.add(i);
        }

        LinkedList<Integer> targets = new LinkedList<>();
        st = new StringTokenizer(bf.readLine(), " ");
        while (st.hasMoreTokens()) {
            targets.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        while (!targets.isEmpty()) {
            int target = targets.poll();
            int targetIdx = circularQueue.indexOf(target);

            int half = (int) Math.ceil((double) circularQueue.size() / 2);
            if (targetIdx < half) { // 오른쪽
                while (!circularQueue.isEmpty() && circularQueue.peekFirst() != target) {
                    circularQueue.addLast(circularQueue.pollFirst());
                    result++;
                }
                circularQueue.removeFirst();
            } else { // 왼쪽
                while (!circularQueue.isEmpty() && circularQueue.peekFirst() != target) {
                    circularQueue.addFirst(circularQueue.pollLast());
                    result++;
                }
                circularQueue.removeFirst();
            }
        }
        System.out.println(result);
    }
}
