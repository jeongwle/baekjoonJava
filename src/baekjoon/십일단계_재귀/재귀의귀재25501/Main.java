package baekjoon.십일단계_재귀.재귀의귀재25501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        final int CASE = toInt(bf.readLine());

        for (int i = 0; i < CASE; i++) {
            System.out.println(isPalindrome(bf.readLine()) + " " + count);
        }
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static int recursion(String s, int l, int r) {
        count++;
        if (l >= r) {
            return 1;
        } else if (s.charAt(l) != s.charAt(r)) {
            return 0;
        }
        return recursion(s, l + 1, r - 1);
    }

    public static int isPalindrome(String s) {
        count = 0;
        return recursion(s, 0, s.length() - 1);
    }
}
