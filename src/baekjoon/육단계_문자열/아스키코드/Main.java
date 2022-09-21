package baekjoon.육단계_문자열.아스키코드;
/*
백준 11654
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        final AsciiValue asciiValue = new AsciiValue(input.charAt(0));
        asciiValue.printAsciiValue();
    }
}

class AsciiValue {
    private final char ch;

    AsciiValue(char ch) {
        validateCh(ch);
        this.ch = ch;
    }

    private void validateCh(char ch) {
        if (!isLowerAlpha(ch) && !isUpperAlpha(ch) && !isNumber(ch)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private boolean isLowerAlpha(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    private boolean isUpperAlpha(char ch) {
        return (ch >= 'A' && ch <= 'Z');
    }

    private boolean isNumber(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    public void printAsciiValue() {
        System.out.println((int)ch);
    }
}
