package baekjoon.사단계_일차원배열.나머지;
/*
백준 3052
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        final PrintResult printResult = new PrintResult(nums);
        printResult.countDifRem();
        System.out.println(printResult);
    }
}

class PrintResult {
    private final int[] remainders = new int[10];
    private int count = 1;

    PrintResult(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            Num number = new Num(nums[i]);
            int DIVIDE_NUM = 42;
            this.remainders[i] = number.getNum() % DIVIDE_NUM;
        }
    }

    public void countDifRem() {
        sort();
        for (int i = 1; i < remainders.length; i++) {
            if (remainders[i] != remainders[i - 1]) {
                count++;
            }
        }
    }

    private void sort() {
        Arrays.sort(remainders);
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}

class Num {
    private final int num;

    Num(int num) {
        validateNum(num);
        this.num = num;
    }

    private void validateNum(int num) {
        if (num < 0 || num > 1000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public int getNum() {
        return this.num;
    }
}
