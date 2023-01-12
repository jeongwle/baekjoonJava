package baekjoon.기타.단축키지정1283;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        boolean[] shortCut = new boolean[26];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] input = bf.readLine().split(" ");

            boolean change = false;
            for (int j = 0; j < input.length; j++) {
                char c = input[j].charAt(0);
                int index = findIndex(c);

                if (!shortCut[index]) {
                    shortCut[index] = true;
                    input[j] = makeBracket(input[j], 0);
                    change = true;
                    break;
                }
            }

            if (change) {
                for (String s : input) {
                    sb.append(s)
                            .append(" ");
                }
                sb.append("\n");
                continue;
            }

            loop1:
            for (int j = 0; j < input.length; j++) {
                for (int k = 1; k < input[j].length(); k++) {
                    char c = input[j].charAt(k);
                    int index = findIndex(c);

                    if (!shortCut[index]) {
                        shortCut[index] = true;
                        input[j] = makeBracket(input[j], k);
                        break loop1;
                    }
                }
            }

            for (String s : input) {
                sb.append(s)
                        .append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int findIndex(char c) {
        if (Character.isLowerCase(c)) {
            return c - 'a';
        }
        return c - 'A';
    }

    private static String makeBracket(String input, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i == index) {
                sb.append("[")
                        .append(input.charAt(i))
                        .append("]");
            } else {
                sb.append(input.charAt(i));
            }
        }
        return String.valueOf(sb);
    }
}
