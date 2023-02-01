package baekjoon.단계7_문자열.단어공부;
/*
백준 1157
 */


import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final MostUsedAlpha mostUsedAlpha = new MostUsedAlpha(scanner.nextLine());
        mostUsedAlpha.printResult();
    }
}

class MostUsedAlpha {
    private final String input;
    private final int[] check = new int[26];

    // 애초에 토큰검사를 소문자만하고 input.toLowerCase를 넘긴다?
    MostUsedAlpha(String input) {
        validateInput(input);
        this.input = input.toLowerCase();
    }

    private void validateInput(String input) {
        StringTokenizer st = new StringTokenizer(
                input, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        );
        if (st.hasMoreTokens() || input.length() > 1_000_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private int getIndex(char ch) {
        return (int) ch - (int)'a';
    }

    private void modifyCheck() {
        for (int i = 0; i < input.length(); i++) {
            int index = getIndex(input.charAt(i));
            check[index]++;
        }
    }

    private int findMostUsedIndex() {
        modifyCheck();
        int max = 0;
        int index = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[i] > max) {
                max = check[i];
                index = i;
            }
        }
        return index;
    }

    private char getAlpha(int index) {
        return (char) (index + (int)'A');
    }

    private boolean isMoreThanOne(int index) {
        for (int i = 0; i < check.length; i++) {
            if (check[index] == check[i] && index != i) {
                return true;
            }
        }
        return false;
    }

    public void printResult() {
        int index = findMostUsedIndex();
        if (isMoreThanOne(index)) {
            System.out.println("?");
            return ;
        }
        System.out.println(getAlpha(index));
    }
}
