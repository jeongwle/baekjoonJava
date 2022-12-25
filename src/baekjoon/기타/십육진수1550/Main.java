package baekjoon.기타.십육진수1550;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int A = 10;
    private static final int B = 11;
    private static final int C = 12;
    private static final int D = 13;
    private static final int E = 14;
    private static final int F = 15;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int multiply = (int) Math.pow(16, input.length() - 1 - i);
            if (isNumber(c)) {
                result += Integer.parseInt(String.valueOf(c)) * multiply;
            } else {
                int digit = 0;
                switch (c) {
                    case 'A':
                        digit = A;
                        break;
                    case 'B':
                        digit = B;
                        break;
                    case 'C':
                        digit = C;
                        break;
                    case 'D':
                        digit = D;
                        break;
                    case 'E':
                        digit = E;
                        break;
                    case 'F':
                        digit = F;
                        break;
                }
                result += digit * multiply;
            }
        }
        System.out.println(result);
    }

    public static boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }
}
