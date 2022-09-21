package baekjoon.칠단계_기본수학1.큰수APlusB;
/*
백준 10757
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        final BigNumber bigNumber = new BigNumber(st.nextToken(), st.nextToken());
        System.out.println(bigNumber.add());
    }
}

class BigNumber {
    private final BigInteger num1;
    private final BigInteger num2;

    BigNumber(String num1, String num2) {
        validateInput(num1);
        validateInput(num2);
        this.num1 = new BigInteger(num1);
        this.num2 = new BigInteger(num2);
    }

    private void validateInput(String input) {
        if (input.charAt(0) == '-' || (input.length() == 1 && input.charAt(0) == '0') ||
                input.length() > 10000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public String add() {
        BigInteger result = num1.add(num2);
        return result.toString();
    }
}
