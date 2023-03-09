package baekjoon.단계5_문자열.문자와문자열27866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        int index = Integer.parseInt(bf.readLine()) - 1;
        System.out.println(input.charAt(index));
    }
}
