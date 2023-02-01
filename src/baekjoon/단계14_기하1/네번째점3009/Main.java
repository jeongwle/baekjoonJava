package baekjoon.단계14_기하1.네번째점3009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int[3];
        int[] y = new int[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            x[i] = toInt(st.nextToken());
            y[i] = toInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        if (x[0] == x[1]) {
            sb.append(x[2]);
        } else if (x[0] == x[2]) {
            sb.append(x[1]);
        } else {
            sb.append(x[0]);
        }
        sb.append(" ");
        if (y[0] == y[1]) {
            sb.append(y[2]);
        } else if (y[0] == y[2]) {
            sb.append(y[1]);
        } else {
            sb.append(y[0]);
        }
        System.out.println(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

