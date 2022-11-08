package baekjoon.팰린드롬수1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> order;
        List<Integer> reverseOrder;
        StringBuilder sb = new StringBuilder();
        Loop1 : while (true) {
            order = new ArrayList<>();
            reverseOrder = new ArrayList<>();
            int number = toInt(bf.readLine());
            if (number == 0) {
                break;
            }
            getEachOfDigit(order, number);
            getEachOfDigitReverse(reverseOrder, number);

            for (int i = 0; i < order.size(); i++) {
                if (!order.get(i).equals(reverseOrder.get(i))) {
                    sb.append("no")
                            .append("\n");
                    continue Loop1;
                }
            }
            sb.append("yes")
                    .append("\n");
        }
        System.out.print(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static void getEachOfDigit(List<Integer> res, int number) {
        if (number == 0) {
            return;
        }
        res.add(number % 10);
        getEachOfDigit(res, number / 10);
    }

    public static void getEachOfDigitReverse(List<Integer> res, int number) {
        if (number == 0) {
            return;
        }
        getEachOfDigitReverse(res, number / 10);
        res.add(number % 10);
    }

}
