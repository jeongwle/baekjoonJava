package baekjoon.기타.수이어쓰기2154;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            s.append(i);
        }
        int index = s.indexOf(String.valueOf(N));
        System.out.println(index + 1);
    }
}
