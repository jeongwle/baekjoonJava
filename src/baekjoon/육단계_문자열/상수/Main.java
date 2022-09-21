package baekjoon.육단계_문자열.상수;
/*
백준 2908
 */


import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final Idiot idiot = new Idiot(splitSpace(scanner.nextLine()));
        idiot.printMax();
    }

    static String[] splitSpace(String input) {
        return input.split(" ");
    }
}

class Idiot {
    private final String[] numbers;

    Idiot(String[] numbers) {
        validateNumber(numbers);
        this.numbers = numbers;
    }

    private void validateNumber(String[] numbers) {
        if (numbers.length != 2) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        for (String number : numbers) {
            StringTokenizer st = new StringTokenizer(number, "123456789");
            if (st.hasMoreTokens()) {
                throw new RuntimeException("잘못된 입력입니다.");
            }
        }
    }

    private void reverseNumber() {
        for (int i = 0; i < numbers.length; i++) {
            StringBuffer sb = new StringBuffer(numbers[i]);
            numbers[i] = new String(sb.reverse());
        }
    }

    public void printMax() {
        reverseNumber();
        System.out.println(Math.max(toInt(numbers[0]), toInt(numbers[1])));
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }
}
