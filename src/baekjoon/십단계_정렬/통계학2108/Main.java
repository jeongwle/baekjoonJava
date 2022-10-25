package baekjoon.십단계_정렬.통계학2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numOfIn = toInt(bf.readLine());
        int[] numbers = new int[numOfIn];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = toInt(bf.readLine());
        }

        Statistics st = new Statistics(numOfIn, numbers);
        st.printResult();
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class Statistics {
    /*
        NUMBER_OF_INPUT : 주어지는 정수의 총 개수. 1 <= <= 500,000 홀수
        NUMBERS : 주어진 정수들을 담은 배열 절댓값이 4000을 넘지 않음.
     */
    private final int NUMBER_OF_INPUT;
    private final int[] NUMBERS;

    public Statistics(int numOfIn, int[] numbers) {
        validateNumOfIn(numOfIn);
        validateNumbers(numbers);
        NUMBER_OF_INPUT = numOfIn;
        NUMBERS = numbers;
        MergeSort ms = new MergeSort(NUMBERS);
        ms.mergeSort(0, NUMBERS.length - 1);
    }

    private void validateNumOfIn(int numOfIn) {
        if (numOfIn < 1 || numOfIn > 500_000 || numOfIn % 2 == 0) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private void validateNumbers(int[] numbers) {
        for (int number : numbers) {
            if (Math.abs(number) > 4000) {
                throw new RuntimeException("잘못된 입력입니다.");
            }
        }
    }

    // 산술 평균
    private int getArithmeticMean() {
        int sum = 0;
        for (int number : NUMBERS) {
            sum += number;
        }
        return (int)Math.round((double) sum / NUMBER_OF_INPUT);
    }

    // 중앙값
    private int getMedianValue() {
        int index = NUMBER_OF_INPUT / 2;
        return NUMBERS[index];
    }

    // 최빈값
    private int getMode() {
        Mode md = new Mode(NUMBERS);
        return md.getMode();
    }

    // 범위
    private int getRange() {
        return NUMBERS[NUMBER_OF_INPUT - 1] - NUMBERS[0];
    }

    private void makeString(StringBuilder sb, int result) {
        sb.append(result)
                .append("\n");
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();
        makeString(sb, getArithmeticMean());    // 산술평균
        makeString(sb, getMedianValue());       // 중앙값
        makeString(sb, getMode());              // 최빈값
        makeString(sb, getRange());             // 범위
        System.out.print(sb);
    }
}

class MergeSort {
    private final int[] TARGET;
    private final int[] temp;

    public MergeSort(int[] target) {
        TARGET = target;
        temp = new int[target.length];
    }

    public void mergeSort(int left, int right) {
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
            if (TARGET[i] <= TARGET[j]) {
                temp[tempCur++] = TARGET[i++];
            } else {
                temp[tempCur++] = TARGET[j++];
            }
        }

        while (i <= mid) {
            temp[tempCur++] = TARGET[i++];
        }

        int k = left;
        while (k < tempCur) {
            TARGET[k] = temp[k];
            k++;
        }
    }
}

class Mode {
    private final int[] NUMBERS;
    private final int[] positive = new int[4001];
    private final int[] negative = new int[4001];

    public Mode(int[] numbers) {
        NUMBERS = numbers;
    }

    public int getMode() {
        setMode();
        int posMax = getFrequency(positive);
        int negMax = getFrequency(negative);
        if (posMax > negMax) {
            return findModePos(posMax);
        }
        if (posMax < negMax) {
            return findModeNeg(negMax);
        }
        return findModeBoth(posMax);
    }

    private void setMode() {
        for (int number : NUMBERS) {
            if (number < 0) {
                negative[Math.abs(number)]++;
                continue;
            }
            positive[number]++;
        }
    }

    // positive나 negative를 받아 최대빈도가 몇인지 구하는 함수.
    private int getFrequency(int[] array) {
        int max = -1;
        for (int elem : array) {
            if (elem > max) {
                max = elem;
            }
        }
        return max;
    }

    private int findModePos(int max) {
        int count = 0;
        int temp = 0;
        for (int i = 0; i < positive.length; i++) {
            if (positive[i] == max) {
                count++;
                temp = i;
            }
            if (count == 2) {
                return i;
            }
        }
        return temp;
    }

    private int findModeNeg(int max) {
        int count = 0;
        int temp = 0;
        for (int i = negative.length - 1; i > 0; i--) {
            if (negative[i] == max) {
                count++;
                temp = -i;
            }
            if (count == 2) {
                return -i;
            }
        }
        return temp;
    }

    private int findModeBoth(int max) {
        int count = 0;
        int temp = 0;
        for (int i = negative.length - 1; i > 0; i--) {
            if (negative[i] == max) {
                count++;
                temp = -i;
            }
            if (count == 2) {
                return -i;
            }
        }
        for (int i = 0; i < positive.length; i++) {
            if (positive[i] == max) {
                count++;
                temp = i;
            }
            if (count == 2) {
                return i;
            }
        }
        return temp;
    }
}
