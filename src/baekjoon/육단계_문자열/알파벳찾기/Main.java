package baekjoon.육단계_문자열.알파벳찾기;

/*
백준 10809
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final FindAlpha findAlpha = new FindAlpha(scanner.nextLine());
        findAlpha.printResult();
    }
}

class FindAlpha {
    private final int[] check = new int[26]; // 알파벳 a를 0으로 해서 나온 여부나 위치 저장할 곳
    private final String input;

    FindAlpha(String input) {
        validateInput(input);
        this.input = input;
        Arrays.fill(check, -1);
    }

    private void validateInput(String input) {
        Pattern p = Pattern.compile("[a-z]+");
        Matcher m = p.matcher(input);
        if (!m.matches() || input.length() > 100) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private void modifyCheck() {
        for (int i = 0; i < input.length(); i++) {
            int index = getPos(input.charAt(i));
            if (check[index] == -1) {
                check[index] = i;
            }
        }
    }

    // 알파벳 a가 0이되게 조정
    private int getPos(char ch) {
        return (int) ch - 97;
    }

    public void printResult() {
        modifyCheck();
        for (int elem : check) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
