package baekjoon.기타.기타줄1049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int targetNumber = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int sixMin = Integer.MAX_VALUE;
        int oneMin = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            sixMin = Math.min(sixMin, Integer.parseInt(st.nextToken()));
            oneMin = Math.min(oneMin, Integer.parseInt(st.nextToken()));
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= (targetNumber / 6) + 1; i++) {
            int count = targetNumber - 6 * i;
            if (count < 0) {
                count = 0;
            }
            result = Math.min(result, sixMin * i + oneMin * count);
        }
        System.out.println(result);
    }
}
