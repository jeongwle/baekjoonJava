package baekjoon.단계7_2차원배열.세로읽기10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] words = new String[5];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < words.length; i++) {
            words[i] = bf.readLine();
            max = Math.max(max, words[i].length());
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (String word : words) {
                try {
                    answer.append(word.charAt(i));
                } catch (IndexOutOfBoundsException ignored) {
                }
            }
        }
        System.out.println(answer);
    }
}
