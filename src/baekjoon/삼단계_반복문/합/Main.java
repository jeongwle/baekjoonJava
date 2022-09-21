package baekjoon.삼단계_반복문.합;
/*
백준 8393
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final Input input = new Input(scanner.nextInt());
        System.out.println(input.getSum());
    }
}

class Input {
    static int[] store = new int[10001];
    static {
        store[1] = 1;
        for (int i = 2; i < store.length; i++) {
            store[i] = store[i - 1] + i;
        }
    }
    private final int input;

    Input(int input) {
        if (!validateInput(input)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.input = input;
    }

    private boolean validateInput(int input) {
        return (input >= 1 && input <= 10000);
    }

    public int getSum() {
        return store[this.input];
    }
}
