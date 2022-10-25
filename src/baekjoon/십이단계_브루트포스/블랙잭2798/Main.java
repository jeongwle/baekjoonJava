package baekjoon.십이단계_브루트포스.블랙잭2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int numOfCards = toInt(st.nextToken());
        int max = toInt(st.nextToken());
        int[] cards = new int[numOfCards];

        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < cards.length; i++) {
            cards[i] = toInt(st.nextToken());
        }

        validate(numOfCards, max, cards);
        printResult(cards, max);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static void validate(int numOfCards, int max, int[] cards) {
        validateNumOfCards(numOfCards);
        validateMax(max);
        validateCards(cards);
    }

    public static void validateNumOfCards(int numOfCards) {
        if (numOfCards < 3 || numOfCards > 100) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public static void validateMax(int max) {
        if (max < 10 || max > 300_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public static void validateCards(int[] cards) {
        for (int card : cards) {
            if (card < 1 || card > 100_000) {
                throw new RuntimeException("잘못된 입력입니다.");
            }
        }
    }

    public static void printResult(int[] cards, int max) {
        int sum;
        int temp = 0;
        for (int i = 0; i < cards.length - 2; i++) {
            for (int j = i + 1; j < cards.length - 1; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    sum = cards[i] + cards[j] + cards[k];
                    if (sum == max) {
                        System.out.println(sum);
                        return;
                    }
                    if (sum > temp && sum < max) {
                        temp = sum;
                    }
                }
            }
        }
        System.out.println(temp);

    }
}
