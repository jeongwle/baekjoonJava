package baekjoon.십단계_재귀.병합정렬24060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int numOfNumbers = toInt(st.nextToken());
        int numberOfTimes = toInt(st.nextToken());
        int[] numbers = new int[numOfNumbers];
        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = toInt(st.nextToken());
        }

        MergeSort ms = new MergeSort(numOfNumbers, numberOfTimes, numbers);
        ms.printResult();
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class MergeSort {
    private final int[] NUMBERS;
    private final int NUMBER_OF_TIMES;
    private final int[] temp;
    private int count = 0;
    private int result = -1;

    public MergeSort(int numOfNumbers, int numberOfTimes, int[] numbers) {
        validateInput(numOfNumbers, numberOfTimes, numbers);
        NUMBER_OF_TIMES = numberOfTimes;
        NUMBERS = numbers;
        temp = new int[numbers.length];
    }

    public void printResult() {
        mergeSort(0, NUMBERS.length - 1);
        System.out.println(result);
    }

    private void validateInput(int numOfNumbers, int numberOfTimes, int[] numbers) {
        if (numOfNumbers != numbers.length || numOfNumbers < 5 || numOfNumbers > 500_000 ||
                numberOfTimes < 1 || numberOfTimes > 100_000_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 1_000_000_000) {
                throw new RuntimeException("잘못된 입력입니다.");
            }
        }
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
        int cur = left;

        while (i <= mid && j <= right) {
            if (NUMBERS[i] <= NUMBERS[j]) {
                temp[cur++] = NUMBERS[i++];
            } else {
                temp[cur++] = NUMBERS[j++];
            }
        }

        while (i <= mid) {
            temp[cur++] = NUMBERS[i++];
        }

        while (j <= right) {
            temp[cur++] = NUMBERS[j++];
        }

        int k = left;
        while (k < cur) {
            NUMBERS[k] = temp[k];
            count++;
            if (count == NUMBER_OF_TIMES) {
                result = temp[k];
            }
            k++;
        }
    }
}
