package baekjoon.단계19_그리디알고리즘.주유소13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCity = Integer.parseInt(bf.readLine());
        int[] distance = new int[numberOfCity - 1];
        int[] price = new int[numberOfCity];

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < price.length; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        long minPrice = Integer.MAX_VALUE;
        long cost = 0;
        for (int i = 0; i < price.length - 1; i++) {
            minPrice = Math.min(price[i], minPrice);
            cost += minPrice * distance[i];
        }
        System.out.println(cost);
    }
}
