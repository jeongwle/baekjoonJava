package baekjoon.단계18_누적합.나머지합10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int mod = Integer.parseInt(st.nextToken());

        long[] remainder = new long[mod];
        st = new StringTokenizer(bf.readLine(), " ");

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += Integer.parseInt(st.nextToken()) % mod;
            sum %= mod;
            remainder[sum]++;
        }

        long count = remainder[0];
        for (int i = 0; i < mod; i++) {
            // nC2
            count += (remainder[i] * (remainder[i] - 1)) / 2;
        }
        System.out.println(count);
    }
}
