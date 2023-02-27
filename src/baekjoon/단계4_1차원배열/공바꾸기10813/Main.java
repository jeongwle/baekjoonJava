package baekjoon.단계4_1차원배열.공바꾸기10813;

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
            int indexA = Integer.parseInt(st.nextToken()) - 1;
            int indexB = Integer.parseInt(st.nextToken()) - 1;

            int temp = arr[indexA];
            arr[indexA] = arr[indexB];
            arr[indexB] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int element : arr) {
            sb.append(element)
                    .append(" ");
        }
        System.out.println(sb);
    }
}
