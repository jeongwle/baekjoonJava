package baekjoon.일차원배열.OX퀴즈;

/*
백준 8958
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int CASE = Integer.parseInt(scanner.nextLine());
        final OXResult[] oxResults = new OXResult[CASE];
        for (int i = 0; i < CASE; i++) {
            oxResults[i] = new OXResult(scanner.nextLine());
        }
        final PrintScore printScore = new PrintScore(oxResults);
        printScore.printScore();
    }
}

class PrintScore {
    private final OXResult[] oxResults;

    PrintScore(OXResult[] oxResults) {
        this.oxResults = oxResults;
    }

    public void printScore() {
        for (OXResult oxResult : this.oxResults) {
            int score = getOXResultScore(oxResult.getOXResult());
            System.out.println(score);
        }
    }

    private int getOXResultScore(String oxResult) {
        int score = 0;
        String[] partOfoxResult = splitX(oxResult);
        for (String part : partOfoxResult) {
            score += getConsecScore(part.length());
        }
        return score;
    }

    private String[] splitX(String oxResult) {
        return oxResult.split("X");
    }

    // 연속된 O의 길이를 받아서 점수구하는 함수
    private int getConsecScore(int number) {
        int score = 0;
        for (int i = 0; i < number; i++) {
            score += i + 1;
        }
        return score;
    }

}

class OXResult {
    private final String OXResult;

    OXResult(String OXResult) {
        validateResult(OXResult);
        this.OXResult = OXResult;
    }

    private void validateResult(String OXResult) {
        int length = OXResult.length();
        if (length == 0 || length > 80) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public String getOXResult() {
        return this.OXResult;
    }
}
