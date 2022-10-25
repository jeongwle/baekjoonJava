package baekjoon.십단계_정렬.수정렬하기2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        final int NUMBER_OF_INPUT = toInt(bf.readLine());
        final int[] inputs = new int[NUMBER_OF_INPUT];
        for (int i = 0; i < inputs.length; i++) {
            int input = toInt(bf.readLine());
            validateNumber(input);
            inputs[i] = input;
        }
        Arrays.sort(inputs);
        print(inputs);
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static void validateNumber(int number) {
        if (Math.abs(number) > 1000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    static void print(int[] inputs) {
        for (int input : inputs) {
            System.out.println(input);
        }
    }
}
