package baekjoon.십칠단계_동적계획법1.신나는함수실행9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static final Map<String, Integer> w = new HashMap<>();
    private static int count = 0;
    static {
        for (int i = -50; i < 1; i++) {
            for (int j = -50; j < 51; j++) {
                for (int k = -50; k < 51; k++) {
                    String key = i + " " + j + " " + k;
                    w.put(key, 1);
                }
            }
        }
        for (int i = -50; i < 51; i++) {
            for (int j = -50; j < 1; j++) {
                for (int k = -50; k < 51; k++) {
                    String key = i + " " + j + " " + k;
                    w.put(key, 1);
                }
            }
        }
        for (int i = -50; i < 51; i++) {
            for (int j = -50; j < 51; j++) {
                for (int k = -50; k < 1; k++) {
                    String key = i + " " + j + " " + k;
                    w.put(key, 1);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());

            if (num1 == -1 && num2 == -1 && num3 == -1) {
                break;
            }
            sb.append("w(")
                    .append(num1)
                    .append(", ")
                    .append(num2)
                    .append(", ")
                    .append(num3)
                    .append(") = ")
                    .append(getValue(num1, num2, num3))
                    .append("\n");
        }
        System.out.print(sb);
    }

    public static int getValue(int num1, int num2, int num3) {
        String key = num1 + " " + num2 + " " + num3;
        if (w.containsKey(key)) {
            return w.get(key);
        }
        if (num1 <= 0 || num2 <= 0 || num3 <= 0) {
            w.put(key, 1);
            return 1;
        }
        if (num1 > 20 || num2 > 20 || num3 > 20) {
            int value = getValue(20, 20, 20);
            w.put(key, value);
            return value;
        }
        if (num1 < num2 && num2 < num3) {
            int value = getValue(num1, num2, num3 - 1) + getValue(num1, num2 - 1, num3 - 1) - getValue(
                    num1, num2 - 1, num3);
            w.put(key, value);
            return value;
        }
        int value = getValue(num1 - 1, num2, num3) + getValue(num1 - 1, num2 - 1, num3) + getValue(
                num1 - 1, num2, num3 - 1) - getValue(num1 - 1, num2 - 1, num3 - 1);
        w.put(key, value);
        return value;
    }
}
