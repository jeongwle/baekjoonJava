package baekjoon.단계18_누적합.구간합구하기11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;
    private static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int repeat = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sum = new int[N];

        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        setSum();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            st = new StringTokenizer(bf.readLine(), " ");

            int start = Integer.parseInt(st.nextToken()) - 2;
            int end = Integer.parseInt(st.nextToken()) - 1;

            sb.append(getSum(end) - getSum(start))
                    .append("\n");
        }
        System.out.print(sb);
    }

    private static void setSum() {
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
    }

    private static int getSum(int index) {
        if (index < 0) {
            return 0;
        }
        return sum[index];
    }
}
