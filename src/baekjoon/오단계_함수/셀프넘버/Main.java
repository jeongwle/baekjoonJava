package baekjoon.오단계_함수.셀프넘버;
/*
백준 4673
 */

public class Main {
    public static void main(String[] args) {
        SelfNumber.printSelfNum();
    }
}

class SelfNumber {
    static final int[] numbers = new int[10000];
    static {
        for (int i = 1; i < numbers.length; i++) {
            int index = d(i);
            if (index < 10000) {
                numbers[index]++;
            }
        }
    }

    // 문제에서 나오는 d수열 자기자신과 각 자리수 더하는 함수
    private static int d(int n) {
        int count = getDigit(n);
        int result = n + n % 10;
        for (int i = 1; i < count; i++) {
            result += (n / (int) (Math.pow(10, count - i))) % 10;
        }
        return result;
    }

    // 숫자의 자릿수 구하는 함수
    private static int getDigit(int n) {
        int result = 1;
        while (n / 10 >= 1) {
            result++;
            n /= 10;
        }
        return result;
    }

    public static void printSelfNum() {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
