package baekjoon.기타.이진수덧셈1252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        BigInteger left = new BigInteger(st.nextToken(), 2);
        BigInteger right = new BigInteger(st.nextToken(), 2);
        System.out.println(left.add(right).toString(2));
    }
}
