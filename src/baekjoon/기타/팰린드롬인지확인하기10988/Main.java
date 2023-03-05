package baekjoon.기타.팰린드롬인지확인하기10988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        int mid = input.length() / 2;
        if (input.length() % 2 == 0) {
            for (int i = 0; i < mid; i++) {
                if (input.charAt(mid - i - 1) != input.charAt(mid + i)) {
                    System.out.println(0);
                    return;
                }
            }
            System.out.println(1);
        } else {
            for (int i = 0; i < mid; i++) {
                if (input.charAt(mid - i - 1) != input.charAt(mid + i + 1)) {
                    System.out.println(0);
                    return;
                }
            }
            System.out.println(1);
        }
    }
}
