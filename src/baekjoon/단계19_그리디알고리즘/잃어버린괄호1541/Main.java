package baekjoon.단계19_그리디알고리즘.잃어버린괄호1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), "+-", true);
        int sum = 0;
        int minusSum = 0;
        boolean minus = false;
        while (st.hasMoreElements()) {
            String input = st.nextToken();
            if (input.equals("-") || input.equals("+")) {
                if (input.equals("-") && !minus) {
                    minus = true;
                }
                continue;
            }
            if (!minus) {
                sum += Integer.parseInt(input);
                continue;
            }
            minusSum += Integer.parseInt(input);
        }
        System.out.println(sum - minusSum);
    }
}
