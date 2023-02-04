package baekjoon.단계21_큐와덱.큐18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCommand = Integer.parseInt(bf.readLine());

        MyQueue myQueue = new MyQueue();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCommand; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    myQueue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(myQueue.pop())
                            .append("\n");
                    break;
                case "front":
                    sb.append(myQueue.front())
                            .append("\n");
                    break;
                case "back":
                    sb.append(myQueue.back())
                            .append("\n");
                    break;
                case "empty":
                    sb.append(myQueue.empty())
                            .append("\n");
                    break;
                case "size":
                    sb.append(myQueue.size())
                            .append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }

    static class MyQueue {

        private final LinkedList<Integer> store;

        MyQueue() {
            store = new LinkedList<>();
        }

        public void push(int x) {
            store.add(x);
        }

        public int pop() {
            if (this.size() == 0) {
                return -1;
            }
            return store.removeFirst();
        }

        public int size() {
            return store.size();
        }

        public int empty() {
            if (this.size() == 0) {
                return 1;
            }
            return 0;
        }

        public int front() {
            if (store.size() == 0) {
                return -1;
            }
            return store.peekFirst();
        }

        public int back() {
            if (store.size() == 0) {
                return -1;
            }
            return store.peekLast();
        }
    }
}
