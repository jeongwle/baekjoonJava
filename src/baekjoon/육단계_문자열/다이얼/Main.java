package baekjoon.육단계_문자열.다이얼;
/*
백준 5622
 */


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static final String[] PATTERNS = new String[]{
            "", "", "[A-C]", "[D-F]", "[G-I]", "[J-L]", "[M-O]", "[P-S]", "[T-V]", "[W-Z]"
    };

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int result = 0;

        final String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < PATTERNS.length; j++) {
                Pattern p = Pattern.compile(PATTERNS[j]);
                Matcher m = p.matcher(input.charAt(i) + "");
                if (m.matches()) {
                    result += j + 1;
                }
            }
        }
        System.out.println(result);
    }
}

