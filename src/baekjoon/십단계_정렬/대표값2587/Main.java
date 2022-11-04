package baekjoon.십단계_정렬.대표값2587;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = toInt(bf.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        System.out.println(sum / 5);
        System.out.println(arr[2]);


    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

}
