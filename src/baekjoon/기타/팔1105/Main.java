package baekjoon.기타.팔1105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());

        int eight = 0;

        // 바꿀 수 있는 자리수의 개수
        int ableToChange = numberOfDigit(right - left, 0);

        String leftNumber = String.valueOf(left);
        String rightNumber = String.valueOf(right);

        // 바꿀 수 있는 자리수의 개수 전까지 나오는 8의 개수만 세면 된다. 나머지는 다 바꿔서 8이 아니게 하면 된다. 는 생각으로 짠 코드
        for (int i = 0; i < leftNumber.length() - ableToChange; i++) {
            if (leftNumber.charAt(i) == '8') {
                eight++;
            }
        }

        // 바꿀수 있는 자리를 바꿨을때 그 앞의자리의 수가 바뀔 수 있기 때문에 바뀐다면 뺴주어야 한다.
        int index = leftNumber.length() - ableToChange - 1;
        if ((index >= 0 && index < leftNumber.length()) && leftNumber.charAt(index) == '8'
                && rightNumber.charAt(index) != '8') {
            eight--;
        }

        System.out.println(eight);
    }

    private static int numberOfDigit(int number, int result) {
        if (number == 0) {
            return result;
        }
        return numberOfDigit(number / 10, result + 1);
    }
}
