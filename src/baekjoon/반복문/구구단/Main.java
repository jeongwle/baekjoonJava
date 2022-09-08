package baekjoon.반복문.구구단;

/*
백준 2739
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final MultiplyTable multiplyTable = new MultiplyTable(scanner.nextInt());
        multiplyTable.printMultiplyTable();
    }
}

class MultiplyTable {
    private final int N;

    MultiplyTable(int number) {
        if (!validateInput(number)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.N = number;
    }

    private boolean validateInput(int number) {
        return (number >= 1 && number <= 9);
    }

    public void printMultiplyTable() {
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d * %d = %d%n", this.N, i, this.N * i);
        }
    }
}