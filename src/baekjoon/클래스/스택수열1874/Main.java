package baekjoon.클래스.스택수열1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int end = toInt(bf.readLine());
        List<Integer> answerTemp = new ArrayList<>();
        List<Integer> myAnswer = new ArrayList<>();
        for (int i = 0; i < end; i++) {
            answerTemp.add(toInt(bf.readLine()));
        }
        List<Integer> answer = new ArrayList<>(answerTemp);

        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int target = answerTemp.get(0);
        for (int i = 1; i <= end ; i++) {
            if (target == i) {
                myAnswer.add(i);
                sb.append("+")
                        .append("\n")
                        .append("-")
                        .append("\n");
                answerTemp.remove(0);
                if (!answerTemp.isEmpty()) {
                    target = answerTemp.get(0);
                }
                while (!s.isEmpty() && s.peek() == target) {
                    myAnswer.add(s.pop());
                    sb.append("-")
                            .append("\n");
                    answerTemp.remove(0);
                    if (!answerTemp.isEmpty()) {
                        target = answerTemp.get(0);
                    }
                }
                continue;
            }
            s.push(i);
            sb.append("+")
                    .append("\n");
        }

        if (myAnswer.equals(answer)) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
