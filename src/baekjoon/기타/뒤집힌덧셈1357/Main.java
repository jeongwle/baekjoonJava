package baekjoon.기타.뒤집힌덧셈1357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int number1 = Integer.parseInt(st.nextToken());
        int number2 = Integer.parseInt(st.nextToken());

        System.out.println(Rev(Rev(number1, 0) + Rev(number2, 0), 0));
    }

    public static int Rev(int number, int res) {
        if (number == 0) {
            return res;
        }
        String digit = "";
        if (number / 10 > 0) {
            digit = String.valueOf(number / 10);
        }
        res += (number % 10) * Math.pow(10, digit.length());
        return Rev(number / 10, res);
    }
}
