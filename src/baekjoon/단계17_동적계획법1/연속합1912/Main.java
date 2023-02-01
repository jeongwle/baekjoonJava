package baekjoon.단계17_동적계획법1.연속합1912;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static Integer[] dp;
    private static int[] input;

    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        dp = new Integer[N];
        input = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = input[0];
        max = input[0];

        recur(N - 1);
        System.out.println(max);
    }

    public static int recur(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(recur(n - 1) + input[n], input[n]);

            max = Math.max(dp[n], max);
        }
        return dp[n];
    }
}

//import java.util.Scanner;
//
//public class Main {
//
//    static int[] arr;		// 배열
//    static Integer[] dp;		// 메모이제이션 할 dp
//    static int max;			// 최댓값 변수
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int N = in.nextInt();
//
//        arr = new int[N];
//        dp = new Integer[N];
//
//        for(int i = 0; i < N; i++) {
//            arr[i] = in.nextInt();
//        }
//
//        /*
//         * dp[0]은 첫 원소로 이전에 더이상 탐색할 것이 없기 때문에
//         * arr[0] 자체 값이 되므로 arr[0]으로 초기화 해준다.
//         * max또한 첫 번째 원소로 초기화 해준다.
//         */
//        dp[0] = arr[0];
//        max = arr[0];
//
//        // dp의 마지막 index는 N-1이므로 N-1부터 Top-Down 탐색
//        recur(N - 1);
//
//        System.out.println(max);
//    }
//
//    static int recur(int N) {
//
//        // 탐색하지 않은 인덱스라면
//        if(dp[N] == null) {
//            dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);
//            System.out.println();
//
//            // 해당 dp[N]과 max 중 큰 값으로 max 갱신
//            max = Math.max(dp[N], max);
//        }
//
//        return dp[N];
//    }
//}
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    private static int[] answer;
//    private static List<Integer> answer2 = new ArrayList<>();
//    private static int size;
//
//    private static int MAX = Integer.MIN_VALUE;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader((new InputStreamReader(System.in)));
//
//        size = Integer.parseInt(bf.readLine());
//        int answerSize = 0;
//        for (int i = 1; i <= size; i++) {
//            answerSize += i;
//        }
////        answer = new int[answerSize];
//
//        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
//        for (int i = 0; i < size; i++) {
////            answer[i] = Integer.parseInt(st.nextToken());
//            answer2.add(Integer.parseInt(st.nextToken()));
//            if (MAX < answer2.get(i)) {
//                MAX = answer2.get(i);
//            }
////            if (MAX < answer[i]) {
////                MAX = answer[i];
////            }
//        }
////        setAnswer(2, size);
////        setAnswer2(0, size - 1);
//        setAnswer3(size - 1);
//        System.out.println(MAX);
//
//    }
//
//    public static void setAnswer(int depth, int index) {
//        if (depth == size + 1) {
//            return;
//        }
//        for (int i = 0; i < size - (depth - 1); i++) {
//            int value = 0;
//            for (int j = i; j < i + depth; j++) {
//                value += answer[j];
//            }
//            if (MAX < value) {
//                MAX = value;
//            }
//            answer[index] = value;
//            index++;
//        }
//        setAnswer(depth + 1, index);
//    }
//
//    public static void setAnswer2(int index, int depth) {
//        if (depth == 0) {
//            return;
//        }
//        int plus = 0; // 리스트에서 다음 옆에 원소를 꺼내기위해 인덱스 맞춰주기 위해 더하는 값
//        for (int i = 0; i < depth; i++) {
//            int value = answer2.get(index) + answer2.get(size - depth + plus);
//            if (MAX < value) {
//                MAX = value;
//            }
//            answer2.add(value);
//            index++;
//            plus++;
//        }
//        setAnswer2(index + 1, depth - 1);
//    }
//
//    public static void setAnswer3(int depth) {
//        int index = 0;
//        for (int i = depth; i >= 0; i--) {
//            int plus = 0;
//            for (int j = 0; j < i; j++) {
//                int value = answer2.get(index) + answer2.get(size - i + plus);
//                if (MAX < value) {
//                    MAX = value;
//                }
//                answer2.add(value);
//                index++;
//                plus++;
//            }
//            index++;
//        }
//    }
//}
