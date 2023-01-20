package baekjoon.기타.등차수열의합1419;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashSet;
//import java.util.Set;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//
//        int left = Integer.parseInt(bf.readLine());
//        int right = Integer.parseInt(bf.readLine());
//        int specifiedNumber = Integer.parseInt(bf.readLine());
//
//        Set<Integer> result = new HashSet<>();
//
//        int x = 1;
//        int d = 1;
//        while (x <= right) {
//            int sum = x;
//            for (int i = 1; i < specifiedNumber; i++) {
//                sum += x + i * d;
//            }
//            if (left <= sum && sum <= right) {
//                result.add(sum);
//            } else if (sum < left) {
//                d++;
//                continue;
//            } else {
//                x++;
//                d = 0;
//            }
//            d++;
//        }
//        System.out.println(result.size());
//    }
//
//}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int left = Integer.parseInt(bf.readLine());
        int right = Integer.parseInt(bf.readLine());
        int specifiedNumber = Integer.parseInt(bf.readLine());

        if (specifiedNumber == 2) {
            if (right < 3) {
                System.out.println(0);
            } else if (left < 3) {
                System.out.println(right - 2);
            } else {
                System.out.println(right - left + 1);
            }
        } else if (specifiedNumber == 3) {
            if (right < 6) {
                System.out.println(0);
            } else if (left < 6) {
                System.out.println(right / 3 - 1);
            } else {
                int minusLeft;
                if (left % 3 == 0) {
                    minusLeft = left / 3 - 2;
                } else {
                    minusLeft = left / 3 - 1;
                }
                System.out.println((right / 3 - 1) - (minusLeft));
            }
        } else if (specifiedNumber == 4) {
            if (right < 10) {
                System.out.println(0);
            } else if (left <= 10) {
                if (right >= 14) {
                    System.out.println(right / 2 - 5);
                } else {
                    System.out.println(1);
                }
            } else if (left < 14) {
                if (right >= 14) {
                    System.out.println(right / 2 - 6);
                } else {
                    System.out.println(0);
                }
            } else {
                int minusLeft;
                if (left % 2 == 0) {
                    minusLeft = left / 2 - 1;
                } else {
                    minusLeft = left / 2;
                }
                System.out.println(right / 2 - minusLeft);
            }
        } else {
            if (right < 15) {
                System.out.println(0);
            } else if (left < 15) {
                System.out.println(right / 5 - 2);
            } else {
                int minusLeft;
                if (left % 5 == 0) {
                    minusLeft = left / 5 - 1;
                } else {
                    minusLeft = left / 5;
                }
                System.out.println(right / 5 - minusLeft);
            }
        }
    }
}
