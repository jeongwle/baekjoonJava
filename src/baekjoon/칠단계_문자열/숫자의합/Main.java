package baekjoon.칠단계_문자열.숫자의합;

/*
백준 11720
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        final Sum sum = new Sum(scanner.nextLine());
        sum.printSum();

    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class Sum {
    private final String input;

    Sum(String input) {
        this.input = input;
    }

    public void printSum() {
        System.out.println(getSum());
    }

    private int getSum() {
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            result += toInt(input.charAt(i));
        }
        return result;
    }

    private int toInt(char ch) {
        return Integer.parseInt(String.valueOf(ch));
    }
}
