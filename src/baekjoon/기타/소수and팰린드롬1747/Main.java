package baekjoon.기타.소수and팰린드롬1747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int[] ERATOSTHENES = new int[2_000_001];

    static {
        ERATOSTHENES[1] = 1;
        for (int i = 2; i < 2_000_000; i++) {
            if (ERATOSTHENES[i] == 1) {
                continue;
            }
            for (int j = i * 2; j < ERATOSTHENES.length; j += i) {
                ERATOSTHENES[j] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int start = Integer.parseInt(bf.readLine());
        while (true) {
            if (ERATOSTHENES[start] == 0 && isPalindrome(start)) {
                System.out.println(start);
                break;
            }
            start++;
        }
    }

    private static boolean isPalindrome(int number) {
        String sNumber = String.valueOf(number);
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        sb.reverse();
        return (sNumber.equals(String.valueOf(sb)));
    }
}
