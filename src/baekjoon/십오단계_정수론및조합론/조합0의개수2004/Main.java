package baekjoon.십오단계_정수론및조합론.조합0의개수2004;

/*
주석친 부분들은 처음에 생각한 것들. 근데 시간이 조금 오래걸리는 것 같아서 고민하고 바꿈
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        // nCm
        int N = toInt(st.nextToken());
        int M = toInt(st.nextToken());

        int twoN = getNumberOfTwo(N, 0);
        int twoNMinusM = getNumberOfTwo(N - M, 0);
        int twoM = getNumberOfTwo(M, 0);
        int twoResult = twoN - (twoNMinusM + twoM);

        int fiveN = getNumberOfFive(N, 0);
        int fiveNMinusM = getNumberOfFive(N - M, 0);
        int fiveM = getNumberOfFive(M, 0);
        int fiveResult = fiveN - (fiveNMinusM + fiveM);

        System.out.println(Math.min(twoResult, fiveResult));

//        int result;

//        if ((N - M) > M) {
//            int[] resultN = getNumberOfTwoFive(N - M + 1, N);
//            int[] resultM = getNumberOfTwoFive(1, M);
//            result = Math.min(resultN[0] - resultM[0], resultN[1] - resultM[1]);
//        } else {
//            int[] resultN = getNumberOfTwoFive(M + 1, N);
//            int[] resultM = getNumberOfTwoFive(1, N - M);
//            result = Math.min(resultN[0] - resultM[0], resultN[1] - resultM[1]);
//        }

//        System.out.println(Math.max(result, 0));
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
    public static int getNumberOfTwo(int number, int result) {
        if (number <= 1) {
            return result;
        }
        int proportion = number / 2;
        return getNumberOfTwo(proportion, result + proportion);
    }

    public static int getNumberOfFive(int number, int result) {
        if (number == 0) {
            return result;
        }
        int proportion = number / 5;
        return getNumberOfFive(proportion, result + proportion);
    }

//    public static int[] getNumberOfTwoFive(int start, int end) {
//        int two = 0;
//        int five = 0;
//        int remainder = start % 2;
//
//        if (((start + remainder) / 2) % 2 == 1) {
//            for (int i = start + remainder; i <= end; i += 4) {
//                two += getNumberOfTwo(i, 1);
//            }
//            for (int i = start + remainder + 2; i <= end; i += 4) {
//                two += getNumberOfTwo(i, 2);
//            }
//        } else {
//            for (int i = start + remainder; i <= end; i += 4) {
//                two += getNumberOfTwo(i, 2);
//            }
//            for (int i = start + remainder + 2; i <= end; i += 4) {
//                two += getNumberOfTwo(i, 1);
//            }
//        }
//
////        for (int i = start + remainder; i <= end; i += 2) {
////            two += getNumberOfTwo(i);
////        }
//        remainder = start % 5 == 0 ? 0 : 5 - start % 5;
//        for (int i = start + remainder; i <= end; i += 5) {
//            five += getNumberOfFive(i);
//        }
//        return new int[]{two, five};
//    }

//    public static int getNumberOfTwo(int number, int index) {
//        int result = 0;
//        int denominator = (int) Math.pow(2, index);
//        while (number % denominator == 0) {
//            number /= denominator;
//            result += index;
//        }
//        if (index == 2 && number % 2 == 0) {
//            result++;
//        }
//        return result;
//    }


//    public static int getNumberOfFive(int number) {
//        int result = 0;
//        while (number % 5 == 0) {
//            number /= 5;
//            result++;
//        }
//        return result;
//    }
}
