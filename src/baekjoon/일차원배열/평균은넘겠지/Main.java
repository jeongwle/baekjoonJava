package baekjoon.일차원배열.평균은넘겠지;

/*
백준 4344번
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int CASE = toInt(scanner.nextLine());
        ClassScore[] classScores = new ClassScore[CASE];
        for (int i = 0; i < CASE; i++) {
            String[] input = splitSpace(scanner.nextLine());
            classScores[i] = new ClassScore(input);
            classScores[i].printPercentage();
        }
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static String[] splitSpace(String input) {
        return input.split(" ");
    }
}

class ClassScore {
    private final Score[] classScore;

    ClassScore(String[] input) {
        int STUDENT_NUMBER = toInt(input[0]);
        validateStudNum(STUDENT_NUMBER);
        classScore = new Score[STUDENT_NUMBER];
        setClassScore(input);
    }

    public void printPercentage() {
        System.out.printf("%.3f%s%n", getPercentage(), "%");
    }

    // 퍼센티지 구하기
    private double getPercentage() {
        double percentage = getStudAboveAvg() / classScore.length * 100;
        percentage = Math.round(percentage * 1000);
        percentage /= 1000;
        return percentage;
    }

    // 평균 이상 학생 수 구하기
    private double getStudAboveAvg() {
        double avg = getAverage();
        double student = 0.0;
        for (Score score : classScore) {
            if (score.getScore() > avg) {
                student++;
            }
        }
        return student;
    }

    private double getAverage() {
        double sum = 0.0;
        for (Score score : classScore) {
            sum += score.getScore();
        }
        return sum / classScore.length;
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private void validateStudNum(int studentNum) {
        if (studentNum < 1 || studentNum > 1000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private void setClassScore(String[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            classScore[i] = new Score(toInt(input[i + 1]));
        }
    }
}

class Score {
    private final int score;

    Score(int score) {
        validateScore(score);
        this.score = score;
    }

    private void validateScore(int score) {
        if (score < 0 || score > 100) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public int getScore() {
        return this.score;
    }
}
