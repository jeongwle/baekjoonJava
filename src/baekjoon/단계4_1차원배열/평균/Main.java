package baekjoon.단계4_1차원배열.평균;
/*
백준 1546
 */


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int CASE = scanner.nextInt();
        validateCase(CASE);
        final Score[] scores = new Score[CASE];
        for (int i = 0; i < CASE; i++) {
            scores[i] = new Score(scanner.nextInt());
        }
        final Average average = new Average(scores);
        System.out.println(average.getNewAverage());
    }

    static void validateCase(int number) {
        if (number <= 0 || number > 1000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }
}

class Average {
    private final Score[] scores;

    Average(Score[] scores) {
        validateScores(scores);
        this.scores = scores;
    }

    private void validateScores(Score[] scores) {
        int sum = 0;
        for (Score score : scores) {
            sum += score.getScore();
        }
        if (sum == 0) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public double getNewAverage() {
        return getNewSum() / this.scores.length;
    }

    private double getNewSum() {
        int MAX_SCORE = getMaxScore();
        double sum = 0.0;
        for (Score score : this.scores) {
            sum += score.getScore() / (double) MAX_SCORE * 100;
        }
        return sum;
    }

    private int getMaxScore() {
        sort();
        return scores[scores.length - 1].getScore();
    }

    private void sort() {
        Arrays.sort(scores);
    }
}

class Score implements Comparable<Score>{
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

    @Override
    public int compareTo(Score o) {
        return this.score - o.getScore();
    }
}
