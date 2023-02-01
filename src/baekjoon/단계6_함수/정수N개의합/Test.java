package baekjoon.단계6_함수.정수N개의합;
/*
백준 15596
 */
class Test {
    long sum(int[] a) {
        long sum = 0;
        for (int j : a) {
            sum += j;
        }
        return sum;
    }
}