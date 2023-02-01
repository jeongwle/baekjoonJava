package baekjoon.단계15_정수론및조합론.패션왕신해빈9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int CASE = toInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CASE; i++) {
            int NUMBER_OF_CLOTH = toInt(bf.readLine());
            if (NUMBER_OF_CLOTH == 0) {
                sb.append(0)
                        .append("\n");
                continue;
            }
            HashMap<String, Integer> inputs = new HashMap<>();
            for (int j = 0; j < NUMBER_OF_CLOTH; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
                st.nextToken();
                String input = st.nextToken();
                if (inputs.containsKey(input)) {
                    inputs.put(input, inputs.get(input) + 1);
                } else {
                    inputs.put(input, 1);
                }
            }
            sb.append(getDay(inputs))
                    .append("\n");
        }
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static int getDay(HashMap<String, Integer> inputs) {
        int[] result = new int[inputs.size()];
        Integer[] value = new Integer[inputs.size()];
        inputs.values().toArray(value);

        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                temp += result[j];
            }
            result[i] = value[i] * (1 + temp);
            sum += result[i];
        }
        return sum;
    }
}
