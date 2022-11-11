package baekjoon.클래스.괄호9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int CASE = toInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CASE; i++) {
            List<Character> list = new ArrayList<>();
            String input = bf.readLine();
            for (char ch : input.toCharArray()) {
                list.add(ch);
            }

            for (int j = list.size() - 1; j >= 1; j--) {
                if (list.get(j) == ')' && list.get(j - 1) == '(') {
                    list.remove(j);
                    list.remove(j - 1);
                    j = list.size();
                }
            }
            if (list.size() == 0) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

}
