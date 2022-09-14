package baekjoon.함수.한수;

/*
백준 1065
코드는 맘에 안든다..
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final Hansu hansu = new Hansu(scanner.nextInt());
        hansu.printResult();
    }
}

class Hansu {
    private final int input;

    Hansu(int input) {
        validateInput(input);
        this.input = input;
    }

    private void validateInput(int input) {
        if (input <= 0 || input > 1000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public void printResult() {
        int count = getDigit(input);
        if (count <= 2) {
            System.out.println(input);
            return;
        } else if (count <= 3) {
            System.out.println(get3DigitHansu(input));
            return;
        }
        System.out.println(get3DigitHansu(999));
    }

    private int get3DigitHansu(int input) {
        int result = 99;
        for (int i = 100; i <= input; i++) {
            int hundred = getEachDigit(3, i);
            int ten = getEachDigit(2, i);
            int one = getEachDigit(1, i);
            if (hundred - ten == ten - one) {
                result++;
            }
        }
        return result;
    }

    private int getEachDigit(int digit, int number) {
        if (digit == 1) {
            return number % 10;
        }
        return (number / (int) (Math.pow(10, digit - 1))) % 10;
    }

    private int getDigit(int number) {
        int result = 1;
        while (number / 10 >= 1) {
            result++;
            number /= 10;
        }
        return result;
    }
}
