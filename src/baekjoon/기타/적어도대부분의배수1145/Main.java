package baekjoon.기타.적어도대부분의배수1145;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = arr[0];
        while (true) {
            int count = 0;
            for (int number : arr) {
                if (answer % number == 0) {
                    count++;
                }
            }
            if (count >= 3) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }

}
