package baekjoon.구단계_정렬.소트인사이드1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        SortInside si = new SortInside(bf.readLine());
        si.printResult();
    }
}

class SortInside {
    private final String input;
    private final int[] result;

    public SortInside(String input) {
        validateInput(input);
        this.input = input;
        result = new int[input.length()];
    }

    private void validateInput(String input) {
        int number = toInt(input);
        if (number < 1 || number > 1_000_000_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private void setResult() {
        StringTokenizer st = new StringTokenizer(input, "0123456789", true);
        for (int i = 0; i < result.length; i++) {
            result[i] = toInt(st.nextToken());
        }
    }

    private void sortDescending() {
        setResult();
        MergeSortReverse msr = new MergeSortReverse(result);
        msr.mergeSort(0, result.length - 1);
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();
        sortDescending();
        for (int elem : result) {
            sb.append(elem);
        }
        sb.append("\n");
        System.out.print(sb);
    }
}

class MergeSortReverse {
    private final int[] input;
    private final int[] temp;

    MergeSortReverse(int[] input) {
        this.input = input;
        temp = new int[input.length];
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
        int cur = left;

        while (i <= mid && j <= right) {
            if (input[i] >= input[j]) {
                temp[cur++] = input[i++];
            } else {
                temp[cur++] = input[j++];
            }
        }

        while (i <= mid) {
            temp[cur++] = input[i++];
        }

        int k = left;
        while (k < cur) {
            input[k] = temp[k];
            k++;
        }
    }
}
