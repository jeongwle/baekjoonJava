package baekjoon.단계17_동적계획법1.일로만들기1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int inputNumber = Integer.parseInt(bf.readLine());
        dp = new Integer[inputNumber + 1];
        dp[0] = 0;
        dp[1] = 0;
        System.out.println(count(inputNumber));
    }

//    public static int recur(int inputNumber, int count) {
//        if (inputNumber == 1) {
//            dp[inputNumber] = count;
//            return dp[inputNumber];
//        }
//        if (dp[inputNumber] == null) {
//            System.out.println("inputNumber = " + inputNumber);
//            if (inputNumber % 3 == 0) {
//                dp[inputNumber] = recur(inputNumber / 3, count + 1);
//            } else if (inputNumber % 2 == 0) {
//                dp[inputNumber] = recur(inputNumber / 2, count + 1);
//            } else {
//                dp[inputNumber] = recur(inputNumber - 1, count + 1);
//            }
//        }
//
//        return dp[inputNumber];
//    }

    public static int count(int inputNumber) {
        if (dp[inputNumber] == null) {
            if (inputNumber % 6 == 0) {
                dp[inputNumber] = Math.min(count(inputNumber - 1),
                        Math.min(count(inputNumber / 3), count(inputNumber / 2))) + 1;
            } else if (inputNumber % 3 == 0) {
                dp[inputNumber] = Math.min(count(inputNumber / 3), count(inputNumber - 1)) + 1;
            } else if (inputNumber % 2 == 0) {
                dp[inputNumber] = Math.min(count(inputNumber / 2), count(inputNumber - 1)) + 1;
            } else {
                dp[inputNumber] = count(inputNumber - 1) + 1;
            }
        }
        return dp[inputNumber];
    }
}
