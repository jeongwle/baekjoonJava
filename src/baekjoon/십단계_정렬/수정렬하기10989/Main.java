package baekjoon.십단계_정렬.수정렬하기10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        final int NUMBER_OF_INPUT = toInt(bf.readLine());
        final int[] list = new int[NUMBER_OF_INPUT];
        temp = new int[NUMBER_OF_INPUT];
        for (int i = 0; i < list.length; i++) {
            int input = toInt(bf.readLine());
            list[i] = input;
        }
        mergeSort(list, 0, list.length - 1);

        StringBuilder sb = new StringBuilder(10000);
        for (int elem : list) {
            sb.append(elem)
                    .append("\n");
        }
        System.out.print(sb);
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static void mergeSort(int[] list, int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    static void merge(int[] list, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int tempCur = left;

        while (i <= mid && j <= right) {
            if (list[i] <= list[j]) {
                temp[tempCur++] = list[i++];
            } else {
                temp[tempCur++] = list[j++];
            }
        }

        while (i <= mid) {
            temp[tempCur++] = list[i++];
        }

        for (int k = left; k < tempCur; k++) {
            list[k] = temp[k];
        }
    }
}
