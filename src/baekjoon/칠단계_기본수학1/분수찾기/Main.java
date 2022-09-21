package baekjoon.칠단계_기본수학1.분수찾기;
/*
백준 1193
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int TARGET = scanner.nextInt();
        validateTarget(TARGET);

        int[] line = new int[5000];

        for (int i = 1; i < line.length; i++) {
            line[i] = i + line[i - 1];
        }

        int startIndex = (int) (Math.sqrt(TARGET));
        while (TARGET > line[startIndex]) {
            startIndex++;
        }

        int diff = line[startIndex] - TARGET;

        int denominator = 0; // 분모
        int numerator = 0; // 분자

        if (isOdd(startIndex)) {
            denominator = startIndex - diff;
            numerator = 1 + diff;
        } else {
            denominator = 1 + diff;
            numerator = startIndex - diff;
        }

        System.out.println(numerator + "/" + denominator);
    }

    static void validateTarget(int target) {
        if (target < 1 || target > 10_000_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    static boolean isOdd(int index) {
        return index % 2 == 1;
    }
}

