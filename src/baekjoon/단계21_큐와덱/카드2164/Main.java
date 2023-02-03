package baekjoon.단계21_큐와덱.카드2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = toInt(bf.readLine());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (q.size() != 1) {
            q.poll();
            q.offer(q.poll());
        }
        System.out.println(q.peek());
//        int tempN = N;
//        int count = 0;
//
//        if (N % 2 == 0) {
//            while (tempN % 2 == 0) {
//                tempN /= 2;
//                count++;
//            }
//
//            int start = (int) Math.pow(2, count);
//            for (int i = start; i <= N; i += start) {
//                inputNumbers.add(i);
//            }
//        } else {
//            for (int i = 4; i < N ; i+= 2) {
//                inputNumbers.add(i);
//            }
//            inputNumbers.addLast(2);
//        }
//
//        int size;
//        while ((size = inputNumbers.size()) != 1) {
//            if (size % 2 == 0) {
//                for (int i = size - 2; i >= 0; i -= 2) {
//                    inputNumbers.remove(i);
//                }
//            } else {
//                for (int i = size - 1; i >= 0 ; i -= 2) {
//                    inputNumbers.remove(i);
//                }
//                int temp = inputNumbers.get(0);
//                inputNumbers.removeFirst();
//                inputNumbers.addLast(temp);
//            }
//        }
//        System.out.println(inputNumbers.get(0));
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

}
