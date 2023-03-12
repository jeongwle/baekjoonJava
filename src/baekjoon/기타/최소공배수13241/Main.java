package baekjoon.기타.최소공배수13241;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int numberOne = Integer.parseInt(st.nextToken());
        int numberTwo = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> factorizationOne = new HashMap<>();
        while (numberOne > 1) {
            for (int i = 2; i <= numberOne; i++) {
                if (numberOne % i == 0) {
                    factorizationOne.put(i, factorizationOne.getOrDefault(i, 0) + 1);
                    numberOne /= i;
                    break;
                }
            }
        }

        Map<Integer, Integer> factorizationTwo = new HashMap<>();
        while (numberTwo > 1) {
            for (int i = 2; i <= numberTwo; i++) {
                if (numberTwo % i == 0) {
                    factorizationTwo.put(i, factorizationTwo.getOrDefault(i, 0) + 1);
                    numberTwo /= i;
                    break;
                }
            }
        }

        Set<Integer> oneKey = new HashSet<>(factorizationOne.keySet());
        Set<Integer> twoKey = new HashSet<>(factorizationTwo.keySet());
        oneKey.addAll(twoKey);

        long result = 1;
        for (Integer key : oneKey) {
            int pow;
            if (factorizationOne.containsKey(key) && factorizationTwo.containsKey(key)) {
                pow = Math.max(factorizationOne.get(key), factorizationTwo.get(key));
            } else if (factorizationOne.containsKey(key)) {
                pow = factorizationOne.get(key);
            } else {
                pow = factorizationTwo.get(key);
            }
            result *= Math.pow(key, pow);
        }
        System.out.println(result);
    }
}
