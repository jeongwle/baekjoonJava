package baekjoon.단계2_조건문.윤년;

/*
윤년이면 1 아니면 0
4의 배수이면서 100의 배수가 아닐 때
400의 배수일때
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final Year year = new Year(scanner.nextInt());
        int result = isLeapYear(year.getYear()) ? 1 : 0;
        System.out.println(result);
    }

    static boolean isLeapYear(int year) {
        return (year % 100 != 0 && year % 4 == 0 || year % 400 == 0);
    }
}

class Year {
    private final int year;

    Year(int year) {
        if (year < 1 || year > 4000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.year = year;
    }

    int getYear() {
        return this.year;
    }

}