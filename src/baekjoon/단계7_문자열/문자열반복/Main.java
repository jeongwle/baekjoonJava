package baekjoon.단계7_문자열.문자열반복;
/*
백준 2675
 */


import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int CASE = toInt(scanner.nextLine());

        for (int i = 0; i < CASE; i++) {
            String[] input = splitSpace(scanner.nextLine());
            final RepeatString repeatString = new RepeatString(toInt(input[0]), input[1]);
            System.out.println(repeatString.makeResult());
        }


    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static String[] splitSpace(String input) {
        return input.split(" ");
    }
}

class RepeatString {
    private final int REPEAT_NUMBER;
    private final String input;

    RepeatString(int repeatNum, String input) {
        validateNumber(repeatNum);
        validateInput(input);
        this.REPEAT_NUMBER = repeatNum;
        this.input = input;
    }

    private void validateInput(String input) {
        StringTokenizer st = new StringTokenizer(
                input, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\\$%*+-./: "
        );
        if (!(input.length() >= 1 && input.length() <= 20) || st.hasMoreTokens()) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private void validateNumber(int repeatNum) {
        if (!(repeatNum >= 1 && repeatNum <= 8)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public String makeResult() {
        StringBuffer sb = new StringBuffer(160);
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < REPEAT_NUMBER; j++) {
                sb.append(input.charAt(i));
            }
        }
        return String.valueOf(sb);
    }
}
