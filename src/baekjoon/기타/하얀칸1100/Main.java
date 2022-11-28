package baekjoon.기타.하얀칸1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        for (int i = 0; i < 8; i++) {
            String input = bf.readLine();
            if (i % 2 == 0) {
                for (int j = 0; j < input.length(); j++) {
                    if (j % 2 == 0 && input.charAt(j) == 'F') {
                        count++;
                    }
                }
            } else {
                for (int j = 0; j < input.length(); j++) {
                    if (j % 2 == 1 && input.charAt(j) == 'F') {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
