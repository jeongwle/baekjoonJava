package baekjoon.기타.꼬마정민11382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        BigInteger answer = new BigInteger(st.nextToken());
        while (st.hasMoreTokens()) {
            answer = answer.add(new BigInteger(st.nextToken()));
        }
        System.out.println(answer);
    }
}
