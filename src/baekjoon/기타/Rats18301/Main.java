package baekjoon.기타.Rats18301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int numberOne = Integer.parseInt(st.nextToken());
        int numberTwo = Integer.parseInt(st.nextToken());
        int numberThree = Integer.parseInt(st.nextToken());

        System.out.println((((numberOne + 1) * (numberTwo + 1)) / (numberThree + 1)) - 1);
    }
}
