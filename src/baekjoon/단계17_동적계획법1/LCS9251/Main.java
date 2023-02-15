package baekjoon.단계17_동적계획법1.LCS9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static Integer[][] dp;
    private static char[] strA;
    private static char[] strB;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        strA = bf.readLine().toCharArray();
        strB = bf.readLine().toCharArray();

        dp = new Integer[strB.length][strA.length];
        System.out.println(LCS(strB.length - 1, strA.length - 1));
    }

    private static int LCS(int x, int y) {
        if (x == -1 || y == -1) {
            return 0;
        }

        if (dp[x][y] == null) {
            dp[x][y] = 0;
            if (strA[y] == strB[x]) {
                dp[x][y] = LCS(x - 1, y - 1) + 1;
            } else {
                dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
            }
        }
        return dp[x][y];
    }
}
