package baekjoon.일단계_입출력과사칙연산.곱셈;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstInput = scanner.nextInt();
        int secondInput = scanner.nextInt();
        int firstLine = secondInput % 10 * firstInput;
        int secondLine = secondInput / 10 % 10 * firstInput;
        int thirdLine = secondInput / 100 * firstInput;
        System.out.println(firstLine);
        System.out.println(secondLine);
        System.out.println(thirdLine);
        System.out.println(firstLine + secondLine * 10 + thirdLine * 100);
    }
}
