package baekjoon.기타.이상한곱셈1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        String N = st.nextToken();
        String M = st.nextToken();

        long answer = 0;
        for (char n : N.toCharArray()) {
            for (char m : M.toCharArray()) {
                answer += Long.parseLong(String.valueOf(n)) * Long.parseLong(String.valueOf(m));
            }
        }

        System.out.println(answer);

//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//
//        List<Integer> nDigit = new ArrayList<>();
//        List<Integer> mDigit = new ArrayList<>();
//
//        getEachDigit(N, nDigit);
//        getEachDigit(M, mDigit);
//
//        System.out.println(getAnswer(nDigit, mDigit));
    }

//    public static void getEachDigit(int number, List<Integer> digit) {
//        if (number == 0) {
//            return;
//        }
//        getEachDigit(number / 10, digit);
//        digit.add(number % 10);
//    }
//
//    public static long getAnswer(List<Integer> nDigit, List<Integer> mDigit) {
//        long answer = 0;
//        for (Integer n : nDigit) {
//            for (Integer m : mDigit) {
//                answer += (long) n * m;
//            }
//        }
//        return answer;
//    }
}
