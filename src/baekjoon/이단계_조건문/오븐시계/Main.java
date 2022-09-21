package baekjoon.이단계_조건문.오븐시계;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final OvenAlarm ovenAlarm = new OvenAlarm(scanner.nextInt(), scanner.nextInt());
        final BakeTime bakeTime = new BakeTime(scanner.nextInt());
        Main.printTime(ovenAlarm, bakeTime);

    }

    /*
    무언가 맘에 안들지만 일단은 이렇게 한다...
     */
    private static void printTime(OvenAlarm ovenAlarm, BakeTime bakeTime) {
        int plusHour = calculateMinusHour(bakeTime.getBakeTime());
        int plusMinute = calculateMinusMinute(bakeTime.getBakeTime());
        int resultHour = getResultHour(ovenAlarm.getHour(), plusHour);
        int resultMinute = getResultMinute(ovenAlarm.getMinute(), plusMinute);

        if (resultMinute >= 60) {
            resultHour += 1;
            resultMinute -= 60;
        }
        if (resultHour == 24) {
            resultHour = 0;
        }
        System.out.printf("%d %d%n", resultHour, resultMinute);
    }

    private static int calculateMinusHour(int bakeTime) {
        return bakeTime / 60;
    }

    private static int calculateMinusMinute(int bakeTime) {
        return bakeTime % 60;
    }

    private static int getResultHour(int currenHour, int plusHour) {
        int result = currenHour + plusHour;
        return result > 24 ? result - 24 : result;
    }

    private static int getResultMinute(int currentMinute, int plusMinute) {
        return currentMinute + plusMinute;
    }
}

class OvenAlarm {
    private final int hour;
    private final int minute;

    OvenAlarm(int hour, int minute) {
        if (!validateHour(hour) || !validateMinute(minute)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.hour = hour;
        this.minute = minute;
    }

    private boolean validateHour(int hour) {
        return (hour >= 0 && hour <= 23);
    }

    private boolean validateMinute(int minute) {
        return (minute >= 0 && minute <= 59);
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }
}

class BakeTime {
    private final int bakeTime;

    BakeTime(int bakeTime) {
        if (!validateBakeTime(bakeTime)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.bakeTime = bakeTime;
    }

    private boolean validateBakeTime(int bakeTime) {
        return (bakeTime >= 0 && bakeTime <= 1000);
    }

    public int getBakeTime() {
        return this.bakeTime;
    }
}