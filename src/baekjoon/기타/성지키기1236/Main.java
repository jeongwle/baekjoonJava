package baekjoon.기타.성지키기1236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        Integer[][] answer = new Integer[height][width];
        String[] castle = new String[height];
        for (int i = 0; i < height; i++) {
            castle[i] = bf.readLine();
        }

        for (int i = 0; i < castle.length; i++) {
            for (int j = 0; j < castle[i].length(); j++) {
                if (castle[i].charAt(j) == 'X') {
                    answer[i][j] = 1;
                } else {
                    answer[i][j] = -1;
                }
            }
        }

        Set<Integer> horizontal = new HashSet<>(); // 가로
        Set<Integer> vertical = new HashSet<>(); // 세로

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                if (answer[i][j] == 1) {
                    horizontal.add(i);
                    vertical.add(j);
                }
            }
        }

        int verticalNeed = width - vertical.size();
        int horizontalNeed = height - horizontal.size();
        // 대각선으로 하면 가로 세로 모두 충족가능이기 떄문에 필요한부분에서 둘중 최소값 뺴면 된다.
        int result =
                verticalNeed + horizontalNeed - Math.min(verticalNeed, horizontalNeed);
        System.out.println(result);
//        Integer[] answer = new Integer[width];
//
//        String[] castle = new String[height];
//        for (int i = 0; i < height; i++) {
//            castle[i] = bf.readLine();
//        }
//
//        for (int i = 0; i < castle.length; i++) {
//            for (int j = 0; j < castle[i].length(); j++) {
//                if (answer[j] == null && castle[i].charAt(j) == 'X') {
//                    answer[j] = i;
//                }
//            }
//        }
//
//        System.out.println("answer = " + Arrays.toString(answer));
//        Set<Integer> set = new HashSet<>();
//        for (Integer integer : answer) {
//            if (integer != null) {
//                set.add(integer);
//            }
//        }
//
//        System.out.println(height - set.size());
    }
}
