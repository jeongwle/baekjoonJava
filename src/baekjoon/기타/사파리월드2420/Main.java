package baekjoon.기타.사파리월드2420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        long result = Math.abs(N - M);
        System.out.println(result);
    }
}
