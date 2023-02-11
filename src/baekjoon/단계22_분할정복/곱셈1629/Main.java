package baekjoon.단계22_분할정복.곱셈1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int number = Integer.parseInt(st.nextToken());
        int pow = Integer.parseInt(st.nextToken());
        int mod = Integer.parseInt(st.nextToken());

        System.out.println(divide(number, pow, mod));
    }

    private static long divide(int number, int pow, int mod) {

        if (pow == 1) {
            return number % mod;
        }

        long temp = divide(number, pow / 2, mod);

        if (pow % 2 == 1) {
            return (temp * temp % mod) * number % mod;
        }
        return temp * temp % mod;
    }
}
