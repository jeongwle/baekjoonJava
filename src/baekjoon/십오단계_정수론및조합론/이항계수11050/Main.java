package baekjoon.십오단계_정수론및조합론.이항계수11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = toInt(st.nextToken());
        int K = toInt(st.nextToken());

        int result = factorial(N, 1) / (factorial(N - K, 1) * factorial(K, 1));
        System.out.println(result);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static int factorial(int number, int result) {
        if (number <= 1) {
            return result;
        }
        return factorial(number - 1, number * result);
    }
}
