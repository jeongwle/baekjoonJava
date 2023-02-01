package baekjoon.단계2_조건문.알람시계;

/*
뭔가 클린코드 연습하고 객체지향 이용해보려고 연습하는건데
코드가 쓸데없이 길어지는 느낌이 든다..
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final AlarmClock alarmClock = new AlarmClock(scanner.nextInt(), scanner.nextInt());
        Main.printAlarmTime(alarmClock.getHour(), alarmClock.getMinute());
    }

    public static void printAlarmTime(int hour, int minute) {
        int resultHour = calculateHour(hour, minute);
        int resultMinute = calculateMinute(minute);
        System.out.printf("%d %d%n", resultHour, resultMinute);
    }

    private static int calculateHour(int hour, int minute) {
        if (hour == 0 && minute < 45) {
            return 23;
        } else if (minute < 45) {
            return (hour - 1);
        }
        return hour;
    }

    private static int calculateMinute(int minute) {
        return (minute < 45) ? (minute + 15) : (minute - 45);
    }
}

class AlarmClock {
    private final int hour;
    private final int minute;

    AlarmClock(int hour, int minute) {
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
