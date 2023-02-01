package baekjoon.단계2_조건문.주사위세개;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final Dice dice1 = new Dice(scanner.nextInt());
        final Dice dice2 = new Dice(scanner.nextInt());
        final Dice dice3 = new Dice(scanner.nextInt());
        int prizeMoney = Main.getPrizeMoney(dice1, dice2, dice3);
        System.out.println(prizeMoney);
    }

    /*
    여기는 완전 개판.. 나중에 꼭 리팩토링 하자
     */
    static private int getPrizeMoney(Dice dice1, Dice dice2, Dice dice3) {
        if (dice1.isEqualValue(dice2) && dice1.isEqualValue(dice3)) {
            return (10000 + dice1.getValue() * 1000);
        }
        if (dice1.isEqualValue(dice2) || dice1.isEqualValue(dice3)) {
            return (1000 + dice1.getValue() * 100);
        }
        if (dice2.isEqualValue(dice3)) {
            return (1000 + dice2.getValue() * 100);
        }
        if (dice1.getValue() > dice2.getValue() && dice1.getValue() > dice3.getValue()) {
            return (dice1.getValue() * 100);
        }
        if (dice2.getValue() > dice1.getValue() && dice2.getValue() > dice3.getValue()) {
            return (dice2.getValue() * 100);
        }
        return (dice3.getValue() * 100);

    }
}

class Dice {
    private final int value;

    Dice(int value) {
        if (!validateValue(value)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.value = value;
    }

    private boolean validateValue(int value) {
        return (value >= 1 && value <= 6);
    }

    public int getValue() {
        return this.value;
    }

    public boolean isEqualValue(Dice target) {
        return this.value == target.getValue();
    }
}
