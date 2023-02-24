package baekjoon.단계4_1차원배열.개수세기10807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        bf.readLine();
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int[] arr = new int[201];
        while (st.hasMoreTokens()) {
            int index = toInt(st.nextToken()) + 100;
            arr[index]++;
        }

        int resultIndex = toInt(bf.readLine()) + 100;
        System.out.println(arr[resultIndex]);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
