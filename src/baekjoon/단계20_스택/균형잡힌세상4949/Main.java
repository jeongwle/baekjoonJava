package baekjoon.단계20_스택.균형잡힌세상4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = bf.readLine();
            if (input.equals(".")) {
                break;
            }

            List<Character> list = new ArrayList<>();

            for (char ch : input.toCharArray()) {
                if (ch == '(' || ch == ')' || ch == '[' || ch == ']') {
                    list.add(ch);
                }
            }

            for (int i = list.size() - 1; i >= 1; i--) {
                if (list.get(i) == ')' && list.get(i - 1) == '(') {
                    list.remove(i);
                    list.remove(i - 1);
                    i = list.size();
                } else if (list.get(i) == ']' && list.get(i - 1) == '[') {
                    list.remove(i);
                    list.remove(i - 1);
                    i = list.size();
                }
            }

            if (list.size() == 0) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append("\n");

        }
        System.out.print(sb);
    }
}
