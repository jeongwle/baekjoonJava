package baekjoon.기타.분수합1735;

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
        // 분자
        int numeratorA = Integer.parseInt(st.nextToken());
        // 분모
        int denominatorA = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine(), " ");
        int numeratorB = Integer.parseInt(st.nextToken());
        int denominatorB = Integer.parseInt(st.nextToken());

        long minCommonMultpl = findMinCommonMultpl(denominatorA, denominatorB);
        int numberatorAnswer =
                (int) ((numeratorA * (minCommonMultpl / denominatorA)) + numeratorB * (minCommonMultpl
                                        / denominatorB));

        for (int i = 2; i <= minCommonMultpl; i++) {
            if (minCommonMultpl % i == 0 && numberatorAnswer % i == 0) {
                minCommonMultpl /= i;
                numberatorAnswer /= i;
                i -= 1;
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append(numberatorAnswer)
                .append(" ")
                .append(minCommonMultpl);
        System.out.println(answer);
    }

    private static long findMinCommonMultpl(int numberA, int numberB) {
        long answer = 1;
        Map<Integer, Integer> factorizationA = new HashMap<>();
        while (numberA > 1) {
            for (int i = 2; i <= numberA; i++) {
                if (numberA % i == 0) {
                    factorizationA.put(i, factorizationA.getOrDefault(i, 0) + 1);
                    numberA /= i;
                    break;
                }
            }
        }

        Map<Integer, Integer> factorizationB = new HashMap<>();
        while (numberB > 1) {
            for (int i = 2; i <= numberB; i++) {
                if (numberB % i == 0) {
                    factorizationB.put(i, factorizationB.getOrDefault(i, 0) + 1);
                    numberB /= i;
                    break;
                }
            }
        }

        Set<Integer> keyA = new HashSet<>(factorizationA.keySet());
        Set<Integer> keyB = new HashSet<>(factorizationB.keySet());
        keyA.addAll(keyB);

        for (Integer key : keyA) {
            int pow;
            if (factorizationA.containsKey(key) && factorizationB.containsKey(key)) {
                pow = Math.max(factorizationA.get(key), factorizationB.get(key));
            } else if (factorizationA.containsKey(key)) {
                pow = factorizationA.get(key);
            } else {
                pow = factorizationB.get(key);
            }
            answer *= Math.pow(key, pow);
        }
        return answer;
    }
}
