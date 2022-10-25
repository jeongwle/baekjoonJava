package baekjoon.십단계_정렬.수정렬하기2751;

/*
합병정렬을 이용한 것은 맞았으나 시간초과로 세번 틀렸다.
일단 그래서 class를 정리하고 그냥 메인에서 풀게했고
System.out.println() 대신 StringBuilder를 사용했다. <- 이놈 중요.. 그냥 프린트는 시간 많이잡아먹는거 같다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        final int NUMBER_OF_INPUT = toInt(bf.readLine());
        final int[] INPUT_LIST = new int[NUMBER_OF_INPUT];
        temp = new int[NUMBER_OF_INPUT];

        for (int i = 0; i < INPUT_LIST.length; i++) {
            INPUT_LIST[i] = toInt(bf.readLine());
        }
        mergeSort(INPUT_LIST, 0, INPUT_LIST.length - 1);
        /*
        시간 아끼고자 StringBuilder 사용
         */
        StringBuilder sb = new StringBuilder(1000000);
        for (int input : INPUT_LIST) {
            sb.append(input)
                    .append("\n");
        }
        System.out.print(sb);

//        MergeSort mg = new MergeSort(NUMBER_OF_INPUT, INPUT_LIST);
//        mg.sort();
//        mg.printResult();

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

//class MergeSort {
//    private final int[] temp;
//    private final int[] list;
//
//    MergeSort(int numOfInput, int[] list) {
//        validateNumOfInput(numOfInput);
////        validateList(list);
//        this.list = list;
//        temp = new int[numOfInput];
//    }
//
//    public void sort() {
//        mergeSort(0, list.length - 1);
//    }
//
//    private void validateNumOfInput(int numOfInput) {
//        if (numOfInput < 1 || numOfInput > 1_000_000) {
//            throw new RuntimeException("잘못된 입력입니다.");
//        }
//    }
//
//    private void validateList(int[] list) {
//        for (int elem : list) {
//            if (Math.abs(elem) > 1_000_000) {
//                throw new RuntimeException("잘못된 입력입니다.");
//            }
//        }
//    }
//
//    private void mergeSort(int left, int right) {
//        if (left < right) {
//            int mid = (left + right) / 2;   // 분할
//            mergeSort(left, mid);           // 앞부분
//            mergeSort(mid + 1, right); // 뒷부분
//            merge(left, mid, right);        // 정렬 및 합병 (나눈 부분 합치기)
//        }
//    }
//
//    private void merge(int left, int mid, int right) {
//        int i = left;
//        int j = mid + 1;
//        int tempCur = left;
//
//        while (i <= mid && j <= right) {
//            if (list[i] <= list[j]) {
//                temp[tempCur++] = list[i++];
//            } else {
//                temp[tempCur++] = list[j++];
//            }
//        }
//
//        /*
//        왼쪽부분이 전부 복사되었다면 남은 오른쪽부분은 모두 정렬되어 있는 상태라는 뜻.
//        그래서 남은 왼쪽부분만 temp에 넣어두고 바뀐부분만 list에 다시 집어넣기 위해
//        밑에 for문의 조건식을 tempCur로 한다.
//         */
//        while (i <= mid) {
//            temp[tempCur++] = list[i++];
//        }
//
//        for (int k = left; k < tempCur; k++) {
//            list[k] = temp[k];
//        }
//    }
//
//    public void printResult() {
//        for (int elem : list) {
//            System.out.println(elem);
//        }
//    }
//}