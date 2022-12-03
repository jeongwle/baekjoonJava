package baekjoon.기타.도비의난독증테스트2204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int number = Integer.parseInt(bf.readLine());
            if (number == 0) {
                break;
            }

            String[] origin = new String[number];
            String[] sort = new String[number];
            for (int i = 0; i < number; i++) {
                origin[i] = bf.readLine();
                sort[i] = origin[i].toLowerCase();
            }
            Arrays.sort(sort);

            for (String text : origin) {
                if (text.equalsIgnoreCase(sort[0])) {
                    sb.append(text)
                            .append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
