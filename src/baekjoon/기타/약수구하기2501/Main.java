package baekjoon.기타.약수구하기2501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // N의 약수들 중 K번째 수를 출력
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                divisors.add(i);
            }
        }

        if (divisors.size() <= K - 1) {
            System.out.println(0);
            return;
        }
        System.out.println(divisors.get(K - 1));
    }
}
