package baekjoon.기타.운동1173;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 운동하고 싶은 시간
        int m = Integer.parseInt(st.nextToken()); // 최소 맥박
        int M = Integer.parseInt(st.nextToken()); // 최대 맥박
        int T = Integer.parseInt(st.nextToken()); // 운동 시 맥박 증가량
        int R = Integer.parseInt(st.nextToken()); // 휴식 시 맥박 감소량

        int result = 0;
        int excercise = 0;

        int firstM = m;

        while (excercise != N && m + T <= M) {
            if (firstM + T <= M) {
                firstM += T;
                excercise++;
            } else {
                if (firstM - R < m) {
                    firstM = m;
                } else {
                    firstM -= R;
                }
            }
            result++;
        }
        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
