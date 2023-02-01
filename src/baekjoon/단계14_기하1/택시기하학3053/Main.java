package baekjoon.단계14_기하1.택시기하학3053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int radius = toInt(bf.readLine());
        System.out.printf("%.6f%n", (Math.pow(radius, 2) * Math.PI));
        System.out.printf("%.6f%n", (Math.pow(radius, 2) * 2));
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
