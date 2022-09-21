package baekjoon.이단계_조건문.두수비교하기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final Value FIRST = new Value(scanner.nextInt());
        final Value SECOND = new Value(scanner.nextInt());
        printOperator(FIRST, SECOND);
    }

    static void printOperator(Value first, Value second) {
        if (first.getVALUE() > second.getVALUE()) {
            System.out.println(">");
            return;
        } else if (first.getVALUE() == second.getVALUE()) {
            System.out.println("==");
            return;
        }
        System.out.println("<");
    }
}

class Value {
    private final int VALUE;

    Value(int value) {
        if (value < -10000 || value > 10000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.VALUE = value;
    }

    public int getVALUE() {
        return this.VALUE;
    }
}
