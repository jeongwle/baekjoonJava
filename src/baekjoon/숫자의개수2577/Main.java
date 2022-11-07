package baekjoon.숫자의개수2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num1 = toInt(bf.readLine());
        int num2 = toInt(bf.readLine());
        int num3 = toInt(bf.readLine());

        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            res.put(i, 0);
        }
        int number = num1 * num2 * num3;

        calculate(res, number);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(res.get(i))
                    .append("\n");
        }
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static void calculate(Map<Integer, Integer> res, int number) {
        if (number == 0) {
            return;
        }
        int digit = number % 10;
        res.put(digit, res.get(digit) + 1);
        calculate(res, number / 10);
    }

}
