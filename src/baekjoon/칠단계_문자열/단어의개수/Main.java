package baekjoon.칠단계_문자열.단어의개수;
/*
백준 1152
 */


import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String input = scanner.nextLine();
        validateInput(input);
        String[] splitResult = splitSpace(input.trim());
        if (splitResult == null) {
            System.out.println(0);
        } else {
            System.out.println(splitResult.length);
        }
    }

    static String[] splitSpace(String input) {
        if (input.length() == 0) {
            return null;
        }
        return input.split(" ");
    }

    static void validateInput(String input) {
        StringTokenizer st = new StringTokenizer(
                input, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ "
        );
        if (st.hasMoreTokens() || input.length() > 1_000_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }
}
