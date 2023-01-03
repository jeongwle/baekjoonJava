package baekjoon.기타.수열의변화1551;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] origin = new int[N];

        st = new StringTokenizer(bf.readLine(), ",");
        for (int i = 0; i < origin.length; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = null;
        int[] temp = origin;
        for (int i = 0; i < K; i++) {
            result = process(temp);
            temp = result;
        }

        StringBuilder sb = new StringBuilder();
        if (result != null) {
            for (int e : result) {
                sb.append(e)
                        .append(",");
            }
        } else {
            for (int e : origin) {
                sb.append(e)
                        .append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }

    private static int[] process(int[] arr) {
        int[] result = new int[arr.length - 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i + 1] - arr[i];
        }
        return result;
    }
}
