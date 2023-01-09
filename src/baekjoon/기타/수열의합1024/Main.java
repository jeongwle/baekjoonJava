package baekjoon.기타.수열의합1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int number = Integer.parseInt(st.nextToken());
        int startLength = Integer.parseInt(st.nextToken());

        Integer[] answer = null;

        while (true) {
            int minus = 0;
            for (int i = 0; i < startLength; i++) {
                minus += i;
            }
            if (number - minus < 0) {
                break;
            }
            if (startLength > 100) {
                break;
            }

            if ((number - minus) % startLength == 0) {
                answer = new Integer[startLength];
                for (int i = 0; i < startLength; i++) {
                    answer[i] = ((number - minus) / startLength) + i;
                }
                break;
            }
            startLength++;
        }
        if (answer == null) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (Integer element : answer) {
                sb.append(element)
                        .append(" ");
            }
            System.out.println(sb);
        }
    }
}
