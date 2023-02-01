package baekjoon.단계2_조건문.시험성적;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final Score score = new Score(scanner.nextInt());
        printGrade(score);
    }

    static void printGrade(Score score) {
        int grade = score.getScore() / 10;
        switch (grade) {
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            default:
                System.out.println("F");
        }
    }
}

class Score {
    private final int Score;

    Score(int score) {
        if (score < 0 || score > 100) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.Score = score;
    }

    int getScore() {
        return this.Score;
    }
}
