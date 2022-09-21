package baekjoon.이단계_조건문.사분면고르기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final Point input = new Point(scanner.nextInt(), scanner.nextInt());
        input.printLocation();
    }
}

class Point {
    private final int x;
    private final int y;

    Point(int x, int y) {
        if (invalidateValue(x) || invalidateValue(y)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.x = x;
        this.y = y;
    }

    private boolean invalidateValue(int target) {
        return (target < -1000 || target > 1000 || target == 0);
    }

    private boolean isPositive(int number) {
        return (number > 0);
    }

    /* if else 안쓰는 방법이 없을까 고민해보자. */
    public void printLocation() {
        if (isPositive(x) && isPositive(y)) {
            System.out.println(1);
        } else if (!isPositive(x) && isPositive(y)) {
            System.out.println(2);
        } else if (!isPositive(x) && !isPositive(y)) {
            System.out.println(3);
        } else {
            System.out.println(4);
        }
    }
}
