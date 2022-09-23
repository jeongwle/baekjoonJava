package baekjoon.구단계_정렬.커트라인25305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int numOfStd = toInt(st.nextToken());
        int numOfWin = toInt(st.nextToken());
        int[] scores = new int[numOfStd];

        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < scores.length; i++) {
            scores[i] = toInt(st.nextToken());
        }

        CutLine cutLine = new CutLine(numOfStd, numOfWin, scores);
        cutLine.printResult();
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class CutLine {
    /*
        NUMBER_OF_WINNER : 상을 받는 학생들의 수
        SCORES : 각 학생들의 점수를 담은 배열
        temp : mergeSort에 사용할 임시배열
     */
    private final int NUMBER_OF_WINNER;
    private final int[] SCORES;
    private final int[] temp;

    public CutLine(int numOfStd, int numOfWin, int[] scores) {
        validateInput(numOfStd, numOfWin);
        validateScores(scores, numOfStd);
        NUMBER_OF_WINNER = numOfWin;
        SCORES = scores;
        temp = new int[numOfStd];
    }

    private void validateScores(int[] scores, int numOfStd) {
        if (numOfStd != scores.length) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        for (int score : scores) {
            if (isInvalid(score, 0, 10000)) {
                throw new RuntimeException("잘못된 입력입니다.");
            }
        }
    }

    private void validateInput(int numOfStd, int numOfWin) {
        if (isInvalid(numOfStd, 1, 1000) || isInvalid(numOfWin, 1, numOfStd)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private boolean isInvalid(int target, int left, int right) {
        return (target < left || target > right);
    }

    private void mergeSort(int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int tempCur = left;

        while (i <= mid && j <= right) {
            if (SCORES[i] <= SCORES[j]) {
                temp[tempCur++] = SCORES[i++];
            } else {
                temp[tempCur++] = SCORES[j++];
            }
        }

        while (i <= mid) {
            temp[tempCur++] = SCORES[i++];
        }

        for (int k = left; k < tempCur; k++) {
            SCORES[k] = temp[k];
        }
    }

    public void printResult() {
        mergeSort(0, SCORES.length - 1);
        StringBuilder sb = new StringBuilder();
        sb.append(SCORES[SCORES.length - NUMBER_OF_WINNER]);
        System.out.println(sb);
    }
}
