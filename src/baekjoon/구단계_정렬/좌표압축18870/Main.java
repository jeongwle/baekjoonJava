package baekjoon.구단계_정렬.좌표압축18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numOfPoints = toInt(bf.readLine());
        int[] origin = new int[numOfPoints]; // 결과 출력을 위해 남겨둔 배열
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        for (int i = 0; st.hasMoreTokens(); i++) {
            origin[i] = toInt(st.nextToken());
        }
        int[] sorted = origin.clone(); // 정렬할 points 배열의 클론.
        MergeSort mg = new MergeSort(numOfPoints, sorted);
        mg.mergeSort(0, sorted.length - 1);

        HashMap<Integer, Integer> result = new HashMap<>();

        // 정렬되어 있으니 맨 왼쪽은 0 차례차례 ++
        int value = 0;
        for (int point : sorted) {
            if (!result.containsKey(point)) {
                result.put(point, value);
                value++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int point : origin) {
            sb.append(result.get(point))
                    .append(" ");
        }
        sb.append("\n");
        System.out.print(sb);
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class MergeSort {
    private final int[] POINTS;
    private final int[] temp;

    public MergeSort(int numOfPoints, int[] points) {
        validateNumOfPoints(numOfPoints);
        validatePoints(points);
        POINTS = points;
        temp = new int[points.length];
    }

    private void validatePoints(int[] points) {
        for (int point : points) {
            if (Math.abs(point) > 1_000_000_000) {
                throw new RuntimeException("잘못된 입력입니다.");
            }
        }
    }

    private void validateNumOfPoints(int numOfPoints) {
        if (numOfPoints < 1 || numOfPoints > 1_000_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
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
            if (POINTS[i] <= POINTS[j]) {
                temp[cur++] = POINTS[i++];
            } else {
                temp[cur++] = POINTS[j++];
            }
        }

        while (i <= mid) {
            temp[cur++] = POINTS[i++];
        }

        int k = left;
        while (k < cur) {
            POINTS[k] = temp[k];
            k++;
        }
    }
}
