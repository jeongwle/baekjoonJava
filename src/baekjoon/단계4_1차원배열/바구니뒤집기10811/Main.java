package baekjoon.단계4_1차원배열.바구니뒤집기10811;

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
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            reverse(arr, start, end);
        }

        StringBuilder sb = new StringBuilder();
        for (int element : arr) {
            sb.append(element)
                    .append(" ");
        }
        System.out.println(sb);
    }

    private static void reverse(int[] arr, int start, int end) {
        int[] temp = new int[end - start + 1];
        int index = 0;
        for (int i = start; i <= end; i++) {
            temp[index] = arr[i];
            index++;
        }

        index = temp.length - 1;
        for (int i = start; i <= end; i++) {
            arr[i] = temp[index];
            index--;
        }
    }
}
