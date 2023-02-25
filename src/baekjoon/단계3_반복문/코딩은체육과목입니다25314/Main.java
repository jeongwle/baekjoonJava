package baekjoon.단계3_반복문.코딩은체육과목입니다25314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N / 4; i++) {
            sb.append("long")
                    .append(" ");
        }
        sb.append("int");
        System.out.print(sb);
    }
}
