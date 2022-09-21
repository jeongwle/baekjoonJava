package baekjoon.칠단계_기본수학1.설탕배달;
/*
백준 2839
풀이가 더럽다.. 어떻게 정리해보아야 할듯.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        final SugarDistributor sd = new SugarDistributor(toInt(bf.readLine()));
        System.out.println(sd.getMinOfBag());
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class SugarDistributor {
    private final int TOTAL_SUGAR;

    SugarDistributor(int totalSugar) {
        validateInput(totalSugar);
        TOTAL_SUGAR = totalSugar;
    }

    private void validateInput(int input) {
        if (input < 3 || input > 5000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public int getMinOfBag() {
        int[] results = new int[TOTAL_SUGAR / 5 + 1]; // 0번은 쓰지 않을 예정
        results[0] = -1;
        for (int i = 1; i < results.length; i++) {
            results[i] = -1;
            if (isDistributableWithFive(i)) {
                results[i] = i + get3KG(i);
            }
        }
        int findResult = findResult(results);
        if (findResult != -1) {
            return findResult;
        }
        if (TOTAL_SUGAR % 3 == 0) {
            return TOTAL_SUGAR / 3;
        }
        return -1;
    }

    private boolean isDistributableWithFive(int index) {
        int temp = TOTAL_SUGAR - 5 * index;
        return temp % 3 == 0;
    }

    private int get3KG(int index) {
        int temp = TOTAL_SUGAR - 5 * index;
        return temp / 3;

    }

    /*
     틀리자 마자 든 생각
     20 같은경우 5가 1개있을떄랑 5가 4개 있을때 두가지의 경우가 있다.
     5kg 봉지가 많을수록 봉지의 수가 제일 작아지기 때문에 i를 0부터 탐색할 것이 아니라
     위에서부터 탐색해야겠다.
     */
    private int findResult(int[] results) {
        for (int i = results.length - 1; i > 0; i--) {
            if (results[i] != -1) {
                return results[i];
            }
        }
        return -1;
    }
}