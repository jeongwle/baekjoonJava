package baekjoon.클래스.제로10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int CASE = toInt(bf.readLine());
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < CASE; i++) {
            int number = toInt(bf.readLine());
            if (number == 0 && !s.isEmpty()) {
                s.pop();
            } else {
                s.push(number);
            }
        }

        int sum = 0;
        while (!s.isEmpty()) {
            sum += s.pop();
        }
        System.out.println(sum);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
