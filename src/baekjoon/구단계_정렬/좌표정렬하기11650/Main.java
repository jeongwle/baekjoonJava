package baekjoon.구단계_정렬.좌표정렬하기11650;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numOfPoints = toInt(bf.readLine());
        Point[] input = new Point[numOfPoints];
        for (int i = 0; i < input.length; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int x = toInt(st.nextToken());
            int y = toInt(st.nextToken());
            input[i] = new Point(x, y);
        }

        SortPoints sortPoints = new SortPoints(numOfPoints, input);
        sortPoints.printResult();
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class SortPoints {
    private final MergeSort mergeSort;

    public SortPoints(int numOfPoints, Point[] input) {
        validateInput(numOfPoints, input.length);
        mergeSort = new MergeSort(input);
    }

    private void validateInput(int numOfPoints, int inputLength) {
        if (numOfPoints != inputLength) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public void printResult() {
        mergeSort.sort();
        System.out.print(mergeSort);
    }
}

class MergeSort {
    private final Point[] temp;
    private final Point[] input;

    public MergeSort(Point[] input) {
        this.input = input;
        this.temp = new Point[input.length];
    }

    public void sort() {
        mergeSort(0, input.length - 1);
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
            if (input[i].getX() < input[j].getX()) {
                temp[cur++] = input[i++];
            } else if (input[i].getX() == input[j].getX()) {
                if (input[i].getY() <= input[j].getY()) {
                    temp[cur++] = input[i++];
                } else {
                    temp[cur++] = input[j++];
                }
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Point point : input) {
            sb.append(point);
        }
        return String.valueOf(sb);
    }
}


class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        validateXY(x, y);
        this.x = x;
        this.y = y;
    }

    private void validateXY(int x, int y) {
        if (Math.abs(x) > 100_000 || Math.abs(y) > 100_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(x)
                .append(" ")
                .append(y)
                .append("\n");
        return String.valueOf(sb);
    }
}

