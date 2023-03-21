package baekjoon.기타.대지9063;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int minW = Integer.MAX_VALUE;
        int maxW = Integer.MIN_VALUE;
        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            minW = Math.min(minW, left);
            maxW = Math.max(maxW, left);

            minH = Math.min(minH, right);
            maxH = Math.max(maxH, right);
        }
        System.out.println((maxW - minW) * (maxH - minH));
    }
}
