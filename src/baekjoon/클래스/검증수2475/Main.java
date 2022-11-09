package baekjoon.클래스.검증수2475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int sum = 0;
        while (st.hasMoreTokens()) {
            sum += Math.pow(toInt(st.nextToken()), 2);
        }
        System.out.println(sum % 10);

    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

}
