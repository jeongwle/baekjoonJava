package baekjoon.기본수학1.손익분기점;
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
        int sales = FIXED_COST / (NOTEBOOK_PRICE - VARIABLE_COST); // 판매량은 고정비용을 (노트북가격 - 가변비용)으로 나눈것보다 커야한다.
        // 나눴을 때 0인 경우 1부터 탐색하도록 해야한다.
        if (sales == 0) {
            sales = 1;
        }
        // 손익분기점 구하기
        while (NOTEBOOK_PRICE <= (FIXED_COST / sales) + VARIABLE_COST) {
            sales++;
        }
        return sales;
    }

}
