package baekjoon.십구단계_그리디알고리즘.동전11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int numberOfCoin = Integer.parseInt(st.nextToken());
        int targetMoney = Integer.parseInt(st.nextToken());

        Stack<Integer> coins = new Stack<>();
        int input;

        for (int i = 0; i < numberOfCoin; i++) {
            input = Integer.parseInt(bf.readLine());
            if (input > targetMoney) {
                break;
            }
            coins.push(input);
        }

        int count = 0;
        while (targetMoney != 0) {
            int coin = coins.pop();
            count += targetMoney / coin;
            targetMoney -= coin * (targetMoney / coin);
        }
        System.out.println(count);
    }
}
