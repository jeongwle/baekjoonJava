package baekjoon.기타.가장큰금민수1526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());
        for (int i = input; i >= 4; i--) {
            if (isPossible(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean isPossible(int number) {
        String sNumber = String.valueOf(number);
        for (char c : sNumber.toCharArray()) {
            if (!(c == '4' || c == '7')) {
                return false;
            }
        }
        return true;
    }
}
