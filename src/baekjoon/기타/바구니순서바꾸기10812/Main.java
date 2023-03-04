package baekjoon.기타.바구니순서바꾸기10812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int CASE = Integer.parseInt(st.nextToken());

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < CASE; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());

            rearrange(arr, start, end, mid);
        }

        StringBuilder answer = new StringBuilder();
        for (int element : arr) {
            answer.append(element)
                    .append(" ");
        }
        System.out.println(answer);
    }

    private static void rearrange(int[] arr, int start, int end, int mid) {
        int[] temp = new int[arr.length];
        System.arraycopy(arr, 0, temp, 0, temp.length);
        int index = start - 1;
        for (int i = mid - 1; i < end; i++) {
            arr[index] = temp[i];
            index++;
        }
        for (int i = start - 1; i < mid - 1; i++) {
            arr[index] = temp[i];
            index++;
        }
    }
}
