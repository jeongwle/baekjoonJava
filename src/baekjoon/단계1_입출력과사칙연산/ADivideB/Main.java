package baekjoon.단계1_입출력과사칙연산.ADivideB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        System.out.println((double)Integer.parseInt(input[0]) / Integer.parseInt(input[1]));
    }
}
