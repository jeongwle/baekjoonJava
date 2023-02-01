package baekjoon.단계3_반복문.APlusB;
/*
백준 10950
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int CASE = scanner.nextInt();
        for (int i = 0; i < CASE; i++) {
            final Number number = new Number(scanner.nextInt());
            final int target = scanner.nextInt();
            System.out.println(number.plusTarget(target));
        }
    }
}

class Number {
    private final int number;

    Number(int number) {
        if (!validateNumber(number)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.number = number;
    }

    private boolean validateNumber(int number) {
        return (number > 0);
    }

    private boolean validateTarget(int target) {
        return (target < 10);
    }

    public int plusTarget(int target) {
        if (!validateTarget(target)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        return (this.number + target);
    }
}
