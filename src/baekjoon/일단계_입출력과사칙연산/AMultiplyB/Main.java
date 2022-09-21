package baekjoon.일단계_입출력과사칙연산.AMultiplyB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        System.out.println(Integer.parseInt(input[0]) * Integer.parseInt(input[1]));
    }
}