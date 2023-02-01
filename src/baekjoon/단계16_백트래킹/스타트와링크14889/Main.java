package baekjoon.단계16_백트래킹.스타트와링크14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[][] ability;
    private static int number;
    private static int[] temp;
    private static int[] temp2;
    private static final List<int[]> caseList = new ArrayList<>(); // 팀 경우의 수 List
    private static final List<int[]> myIndexList = new ArrayList<>(); // 내팀 ability 인덱스들 담은 List
    private static final List<int[]> targetIndexList = new ArrayList<>(); // 적팀 ability 인덱스들 담은 List
    private static int MIN = Integer.MAX_VALUE;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        number = Integer.parseInt(bf.readLine());
        ability = new int[number][number];
        temp = new int[number / 2]; // 팀 경우의수 담을 거
        temp2 = new int[2]; // 1,2가 팀이면 1,2 2,1 점수여야하기 때문이 인덱스 담을거

        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < number; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[number];
        combination(0, number / 2, 0);
//        for (int[] el : caseList) {
//            System.out.println(Arrays.toString(el));
//        }

        calculate();
        System.out.println(MIN);
    }

    public static void combination(int depth, int size, int idx) {
        if (depth == size) {
            caseList.add(temp.clone());
            return;
        }

        for (int i = idx; i < number; i++) {
            if (!visit[i]) {
                visit[i] = true;
                temp[depth] = i;
                combination(depth + 1, size, i);
                visit[i] = false;
            }
        }
    }

    public static void calculate() {
        for (int i = 0; i < caseList.size() / 2; i++) {
            int[] myTeam = caseList.get(i);
            int[] targetTeam = caseList.get(caseList.size() - i - 1);
            teamCombination(0, myTeam, true);
            teamCombination(0, targetTeam, false);

            int myScore = 0;
            for (int[] index : myIndexList) {
                myScore += ability[index[0]][index[1]];
            }
            int targetScore = 0;
            for (int[] index : targetIndexList) {
                targetScore += ability[index[0]][index[1]];
            }

            int result = Math.abs(myScore - targetScore);
            if (MIN > result) {
                MIN = result;
            }
            myIndexList.clear();
            targetIndexList.clear();
        }
    }

    public static void teamCombination(int depth, int[] team, boolean isMine) {
        if (depth == 2) {
            if (isMine) {
                myIndexList.add(temp2.clone());
            } else {
                targetIndexList.add(temp2.clone());
            }
            return;
        }
        for (int i = 0; i < team.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                temp2[depth] = team[i];
                teamCombination(depth + 1, team, isMine);
                visit[i] = false;
            }
        }
    }
}
