package baekjoon.십오단계_정수론및조합론.검문2981;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int CASE = toInt(bf.readLine());
        int[] numbers = new int[CASE];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = toInt(bf.readLine());
        }
        Arrays.sort(numbers);
        MathGame mg = new MathGame(numbers);
        System.out.println(mg.findCd());
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class MathGame {
    private final int[] temp;

    private final List<HashMap<Integer, Integer>> mapList;

    public MathGame(int[] numbers) {
        this.temp = new int[numbers.length - 1];
        for (int i = 1; i < numbers.length; i++) {
            temp[i - 1] = numbers[i] - numbers[i - 1];
        }

        this.mapList = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            mapList.add(new HashMap<>());
        }
        primeFactorization();
    }

    public String findCd() {
        int gcd = findGcd();
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= gcd; i++) {
            if (gcd % i == 0) {
                sb.append(i)
                        .append(" ");
            }
        }
        return String.valueOf(sb);
    }

    private int findGcd() {
        Set<Integer> keys = findKey();
        int gcd = 1;
        for (Integer key : keys) {
            int min = Integer.MAX_VALUE;
            for (HashMap<Integer, Integer> map : mapList) {
                if (min > map.get(key)) {
                    min = map.get(key);
                }
            }
            gcd *= (int)Math.pow(key, min);
        }
        return gcd;
    }

    private Set<Integer> findKey() {
        Set<Integer> res = new HashSet<>(mapList.get(0).keySet());
        for (int i = 1; i < temp.length; i++) {
            res.retainAll(mapList.get(i).keySet());
        }
        return res;
    }
    private void primeFactorization() {
        for (int i = 0; i < temp.length; i++) {
            primeFactorization(temp[i], i);
        }
    }

    private void primeFactorization(int number, int idx) {
        if (number == 1) {
            return;
        }
        int temp = 0;
        HashMap<Integer, Integer> res = mapList.get(idx);
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                temp = i;
                break;
            }
        }
        if (temp != 0) {
            primeFactorization(number / temp, idx);
        }
        if (res.containsKey(temp)) {
            res.put(temp, res.get(temp) + 1);
        } else {
            res.put(temp, 1);
        }
    }
}

//class MathGame {
//    private final int[] numbers;
//    private final int LEAST_DIGIT;
//
//    public MathGame(int[] numbers) {
//        this.numbers = numbers;
//        Arrays.sort(numbers);
//        LEAST_DIGIT = numbers[0] / 10 == 0 ? 1 : numbers[0] / 10;
//    }
//
//    public String findNumber() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 2; i <= 10 * LEAST_DIGIT; i++) {
//            Set<Integer> remainder = new HashSet<>();
//            for (int number : numbers) {
//                remainder.add(number % i);
//            }
//            if (remainder.size() == 1) {
//                sb.append(i)
//                        .append(" ");
//            }
//        }
//        return String.valueOf(sb);
//    }
//}

//class MathGame {
//    private final int[] numbers;
//    private final List<HashMap<Integer, Integer>> mapList;
//
//    public MathGame(int[] numbers) {
//        this.numbers = numbers;
//        this.mapList = new ArrayList<>();
//        for (int i = 0; i < numbers.length; i++) {
//            mapList.add(new HashMap<>());
//        }
//        primeFactorization();
//    }
//
//    public Set<Integer> getIntersection() {
//        Set<Integer> res = new HashSet<>(mapList.get(0).keySet());
//        for (int i = 1; i < numbers.length; i++) {
//            res.retainAll(mapList.get(i).keySet());
//        }
//        return res;
//    }
//
//    private void primeFactorization() {
//        for (int i = 0; i < numbers.length; i++) {
//            primeFactorization(numbers[i], i);
//        }
////        for (int i = 0; i < numbers.length; i++) {
////            System.out.println("mapList.get(i) = " + mapList.get(i));
////        }
//    }
//
//    private void primeFactorization(int number, int idx) {
//        if (number == 1) {
//            return;
//        }
//        int temp = 0;
//        HashMap<Integer, Integer> res = mapList.get(idx);
//        for (int i = 2; i <= number; i++) {
//            if (number % i == 0) {
//                temp = i;
//                break;
//            }
//        }
//        if (temp != 0) {
//            primeFactorization(number / temp, idx);
//        }
//        if (res.containsKey(temp)) {
//            res.put(temp, res.get(temp) + 1);
//        } else {
//            res.put(temp, 1);
//        }
//    }
//}
