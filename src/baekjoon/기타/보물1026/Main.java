package baekjoon.기타.보물1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < A.length; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);

        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result += A[i] * B[i];
        }
        System.out.println(result);
    }
}
