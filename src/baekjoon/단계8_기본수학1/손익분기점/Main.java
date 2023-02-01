package baekjoon.단계8_기본수학1.손익분기점;
/*
백준 1712
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final BreakEvenPoint bep = new BreakEvenPoint(
                scanner.nextInt(), scanner.nextInt(), scanner.nextInt()
        );
        System.out.println(bep.calculateSales());

    }
}

class BreakEvenPoint {
    private final int FIXED_COST;       // 고정 비용 A
    private final int VARIABLE_COST;    // 가변 비용 B
    private final int NOTEBOOK_PRICE;   // 노트북 가격 C

    BreakEvenPoint(int fCost, int vCost, int price) {
        validateInput(fCost);
        validateInput(vCost);
        validateInput(price);
        FIXED_COST = fCost;
        VARIABLE_COST = vCost;
        NOTEBOOK_PRICE = price;
    }

    private void validateInput(int input) {
        if (input < 1 || input > 2_100_000_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public int calculateSales() {
        if (NOTEBOOK_PRICE <= VARIABLE_COST) {
            return -1;
        }
        /*
         판매량은 고정비용을 (노트북가격 - 가변비용)으로 나눈것보다 커야한다.
         그래서 sales 판매량의 시작기준을 고정비용 / (노트북 가격 - 가변비용)으로 한다.
         */
        int sales = FIXED_COST / (NOTEBOOK_PRICE - VARIABLE_COST);
        /*
         손익분기점 구하기 기존 sales로 나누던 코드 때문에 sales가 0일때를 체크하는 코드를 사용했었는데
         조건문을 바꿈으로써 쓸모없는 코드를 줄일 수 있는 것 같아서 바꾸어 보았다.
         */

        while (sales <= FIXED_COST / (NOTEBOOK_PRICE - VARIABLE_COST)) {
            sales++;
        }
        return sales;
    }
}
