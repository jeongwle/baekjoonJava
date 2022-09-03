package baekjoon.Fibonacci;

import java.util.Scanner;

public class Main {
    /*
    피보나치 0은 0출력
    피보나치 1은 1출력
    피보나치 2는 1출력 0출력
    피보나치 3은 1출력 1출력 0출력
    피보나치 4는 1출력 1출력 1출력 0출력 0출력
    피보나치 5는 1출력 1출력 1출력 1출력 1출력 0출력 0출력 0출력
    1은 피보나치수열과 같음. 0은 1부터 피보나치수열
     */
    static int[] data = new int[41];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        final int CASE = Integer.parseInt(input);
        int number;

        for (int i = 0; i < CASE; i++) {
            number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 0:
                    System.out.println("1 0");
                    break;
                case 1:
                    System.out.println("0 1");
                    break;
                default:
                    System.out.println(fibonacci(number - 1) + " " + fibonacci(number));
            }
        }
    }

    static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else if (data[n] != 0) {
            return data[n];
        } else {
            data[n] = fibonacci(n - 1) + fibonacci(n - 2);
            return data[n];
        }
    }
}
