package baekjoon.단계19_그리디알고리즘.회의실배정1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int START = 0;
    private static final int END = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfMeeting = Integer.parseInt(bf.readLine());

        int[][] meetings = new int[numberOfMeeting][2];

        for (int i = 0; i < meetings.length; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            meetings[i][START] = Integer.parseInt(st.nextToken());
            meetings[i][END] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if (o1[END] == o2[END]) {
                return o1[START] - o2[START];
            }
            return o1[END] - o2[END];
        });

        int count = 0;
        int prevEnd = 0;
        for (int[] meeting : meetings) {
            if (prevEnd <= meeting[START]) {
                prevEnd = meeting[END];
                count++;
            }
        }
        System.out.println(count);
    }
}
