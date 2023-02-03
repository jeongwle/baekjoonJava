package baekjoon.단계20_스택.스택10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int CASE = toInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < CASE; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

            String input = st.nextToken();

            switch (input) {
                case "push":
                    int number = toInt(st.nextToken());
                    s.push(number);
                    break;
                case "pop":
                    if (s.empty()) {
                        sb.append(-1);
                    } else {
                        sb.append(s.pop());
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(s.size())
                            .append("\n");
                    break;
                case "empty":
                    if (s.empty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                default:
                    if (s.empty()) {
                        sb.append(-1);
                    } else {
                        sb.append(s.peek());
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
