package baekjoon.십팔단계_누적합.인간컴퓨터상호작용16139;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.StringTokenizer;

// 왜 틀린건지 모르겠다 와이 와이 와이 도대체 무엇이!!!!
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//
//        String input = bf.readLine();
//        int question = Integer.parseInt(bf.readLine());
//
//        Map<Character, Map<Integer, Integer>> store = new HashMap<>();
//        StringBuilder answer = new StringBuilder();
//
//        for (int i = 0; i < question; i++) {
//            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
//
//            char find = st.nextToken().charAt(0);
//
//            // 포함
//            int start = Integer.parseInt(st.nextToken());
//            // 포함
//            int end = Integer.parseInt(st.nextToken());
//
//            if (!store.containsKey(find)) {
//                Map<Integer, Integer> sum = new HashMap<>();
//
//                int value = 1;
//                for (int index = 0; index < input.length(); index++) {
//                    if (input.charAt(index) == find) {
//                        sum.put(index, value);
//                        value++;
//                    }
//                }
//                store.put(find, sum);
//            }
//
//            Map<Integer, Integer> sum = store.get(find);
//
//            int startValue = 0;
//            for (Integer key : sum.keySet()) {
//                if (start <= key) {
//                    startValue = sum.get(key) - 1;
//                    break;
//                }
//                startValue++;
//            }
//
//            int endValue = 0;
//            for (Integer key : sum.keySet()) {
//                if (end < key) {
//                    endValue = sum.get(key) - 1;
//                    break;
//                } else if (end == key) {
//                    endValue = sum.get(key);
//                    break;
//                }
//                endValue++;
//            }
//            answer.append(endValue - startValue)
//                    .append("\n");
//        }
//
//        System.out.print(answer);
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        int[][] sum = new int[input.length()][26];
        sum[0][input.charAt(0) - 'a']++;

        for (int i = 1; i < input.length(); i++) {
            int index = input.charAt(i) - 'a';

            for (int j = 0; j < 26; j++) {
                sum[i][j] = sum[i - 1][j];
            }
            sum[i][index]++;
        }

        int question = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < question; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

            char find = st.nextToken().charAt(0);

            // 포함
            int start = Integer.parseInt(st.nextToken());
            // 포함
            int end = Integer.parseInt(st.nextToken());

            if (start == 0) {
                sb.append(sum[end][find - 'a']);
            } else {
                sb.append(sum[end][find - 'a'] - sum[start - 1][find - 'a']);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
