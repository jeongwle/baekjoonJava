package baekjoon.기타.학점계산2754;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        char first = input.charAt(0);
        double result;
        if (first == 'A') {
            result = 4.3 + getMinus(input.charAt(1));
        } else if (first == 'B') {
            result = 3.3 + getMinus(input.charAt(1));
        } else if (first == 'C') {
            result = 2.3 + getMinus(input.charAt(1));
        } else if (first == 'D') {
            result = 1.3 + getMinus(input.charAt(1));
        } else {
            result = 0.0;
        }
        System.out.println(Math.round(result * 10.0) / 10.0);

    }

    private static double getMinus(char c) {
        if (c == '+') {
            return 0;
        } else if (c == '0') {
            return -0.3;
        }
        return -0.6;
    }
}
