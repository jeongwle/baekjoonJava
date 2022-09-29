package baekjoon.십단계_재귀.하노이탑이동순서11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    @SuppressWarnings("unchecked")
    public static final Stack<Integer>[] poll = new Stack[4];
    public static final StringBuilder sb = new StringBuilder();
    public static final int FROM = 1;
    public static final int REMAINS = 2;
    public static final int TO = 3;
    private static int count = 0;

    static {
        for (int i = 0; i < poll.length; i++) {
            poll[i] = new Stack<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numOfDisc = toInt(bf.readLine());

        validateNumber(numOfDisc);

        for (int i = numOfDisc; i >= 1; i--) {
            poll[1].push(i);
        }
        moveDisc(FROM, TO, REMAINS, numOfDisc);
        printResult();
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static void validateNumber(int number) {
        if (number < 1 || number > 20) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    static void moveDisc(int from, int to, int remains, int number) {
        if (number == 0) {
            return;
        }
        moveDisc(from, remains, to, number - 1); // 제일 큰 원판을 빼고 나머지 장대로 옮김
        poll[to].push(poll[from].pop()); // 제일 큰 원판을 옮김
        count++;
        recordMovingOrder(from, to);
        moveDisc(remains, to, from, number - 1); // 나머지 장대에 있던걸 목표지점으로 옮김
    }

    static void recordMovingOrder(int from, int to) {
        sb.append(from)
                .append(" ")
                .append(to)
                .append("\n");
    }

    static void printResult() {
        System.out.println(count);
        System.out.print(sb);
        count = 0;
        sb.setLength(0);
    }

}

