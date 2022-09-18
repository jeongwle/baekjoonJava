package baekjoon.기본수학1.달팽이는올라가고싶다;
/*
백준 2869 시간초를 위해 짜본 코드
 */

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int CLIMBING_HEIGHT = scanner.nextInt();
        final int FALLING_HEIGHT = scanner.nextInt();
        final int TARGET_HEIGHT = scanner.nextInt();

        int day = (int)Math.ceil(
                (double)(TARGET_HEIGHT - FALLING_HEIGHT) / (CLIMBING_HEIGHT - FALLING_HEIGHT)
        );
        System.out.println(day);
    }
}
