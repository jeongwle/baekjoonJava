package baekjoon.십일단계_브루트포스.영화감독숌1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        final int N = toInt(bf.readLine());
        int count = 0;

        for (int i = 666; i < Integer.MAX_VALUE; i++) {
            if (isValid(i)) {
                count++;
            }
            if (count == N) {
                System.out.println(i);
                break;
            }
        }
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static boolean isValid(int number) {
        String sNum = String.valueOf(number);
        int count = 0;
        for (int i = 1; i < sNum.length(); i++) {
            if (sNum.charAt(i - 1) == '6' && sNum.charAt(i) == '6') {
                count++;
            } else {
                count = 0;
            }
            if (count == 2) {
                return true;
            }
        }
        return false;
    }
}
