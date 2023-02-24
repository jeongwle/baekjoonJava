package baekjoon.단계5_문자열.그룹단어체커;
/*
백준 1316
 */


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int WORD_NUMBER = toInt(scanner.nextLine());
        final String[] words = new String[WORD_NUMBER];
        for (int i = 0; i < WORD_NUMBER; i++) {
            words[i] = scanner.nextLine();
        }

        final Checker checker = new Checker(WORD_NUMBER, words);
        System.out.println(checker.countGroupWord());
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class Checker {
    private final String[] words;

    Checker(int wordNum, String[] words) {
        validateNumber(wordNum);
        validateWord(words);
        this.words = words;
    }

    private void validateNumber(int wordNum) {
        if (wordNum < 1 || wordNum > 100) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private void validateWord(String[] words) {
        for (String word : words) {
            if (word.length() > 100) {
                throw new RuntimeException("잘못된 입력입니다.");
            }
        }
    }

    private boolean isGroupWord(String word) {
        char[] elements = word.toCharArray();
        for (char ch : elements) {
            int prevStart = -1; // 이전 start를 확인할 변수
            Pattern p = Pattern.compile(ch + "");
            Matcher m = p.matcher(word);
            while (m.find()) {
                int distance = m.start() - prevStart;
                if (prevStart != -1 && distance != 1) {
                    return false;
                }
                prevStart = m.start();
            }
        }
        return true;
    }

    public int countGroupWord() {
        int result = 0;
        for (String word : words) {
            if (isGroupWord(word)) {
                result++;
            }
        }
        return result;
    }
}
