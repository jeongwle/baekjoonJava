package baekjoon.팔단계_기본수학1.달팽이는올라가고싶다;
/*
백준 2869
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] input = spaceSplit(scanner.nextLine());
        final int C_HEIGHT = toInt(input[0]);
        final int F_HEIGHT = toInt(input[1]);
        final int T_HEIGHT = toInt(input[2]);
        final ClimbingSnail climbingSnail = new ClimbingSnail(T_HEIGHT, C_HEIGHT, F_HEIGHT);
        System.out.println(climbingSnail.getClimbingDay());
    }

    static String[] spaceSplit(String input) {
        return input.split(" ");
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class ClimbingSnail {
    private final int TARGET_HEIGHT;    // 올라가야 할 목표 높이 V
    private final int CLIMBING_HEIGHT;  // 하루에 올라갈 수 있는 높이 A
    private final int FALLING_HEIGHT;   // 하루에 떨어지는 높이 B

    ClimbingSnail(int tHeight, int cHeight, int fHeight) {
        validateFH(fHeight, cHeight);
        validateCH(cHeight, tHeight);
        validateTH(tHeight);
        TARGET_HEIGHT = tHeight;
        CLIMBING_HEIGHT = cHeight;
        FALLING_HEIGHT = fHeight;
    }

    private void validateFH(int fHeight, int cHeight) {
        if (fHeight < 1 || fHeight >= cHeight) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private void validateCH(int cHeight, int tHeight) {
        if (cHeight > tHeight) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private void validateTH(int tHeight) {
        if (tHeight > 1_000_000_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public int getClimbingDay() {
        /*
        하루가 가기전에 다 못오르면 떨어진다. 하지만 정상에 도달하는 날은 떨어지지 않을 것이므로 목표 높이에서 떨어지는 높이를
        한번 뺴주어야 한다. 그리고 이 값을 하루동안 올라갈 수 있는 순수 높이로 나눈 값을 걸리는 날짜의 기본값으로 하면
        효율을 높일 수 있다.
        손익분기점 문제와 같은 이치.
        하지만 while문은 double형으로 비교를 해야함.
         */
        int day = (TARGET_HEIGHT - FALLING_HEIGHT) / (CLIMBING_HEIGHT - FALLING_HEIGHT);
        System.out.println("day = " +  day);
        while (day < (double) (TARGET_HEIGHT - FALLING_HEIGHT) / (CLIMBING_HEIGHT - FALLING_HEIGHT)) {
            day++;
        }
        return day;
    }
}