package baekjoon.기타.새1568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int count = 0;
        while (N > 0) {
            int index = 1;
            while (N - index >= 0) {
                N -= index;
                index++;
                count++;
            }
        }
        System.out.println(count);
    }
}
