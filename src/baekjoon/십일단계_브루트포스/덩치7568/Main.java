package baekjoon.십일단계_브루트포스.덩치7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int totalNum = toInt(bf.readLine());
        validateTotal(totalNum);

        Person[] people = new Person[totalNum];
        for (int i = 0; i < people.length; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int weight = toInt(st.nextToken());
            int height = toInt(st.nextToken());
            people[i] = new Person(weight, height);
        }
        int[] ranks = compareBody(people);

        StringBuilder sb = new StringBuilder();
        for (int rank : ranks) {
            sb.append(rank + 1)
                    .append(" ");
        }
        System.out.println(sb);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static void validateTotal(int totalNum) {
        if (totalNum < 2 || totalNum > 50) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public static int[] compareBody(Person[] people) {
        int[] result = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            for (int j = i + 1; j < people.length; j++) {
                int cRes = people[i].compareBody(people[j]);
                if (cRes == 1) {
                    result[j]++;
                } else if (cRes == -1) {
                    result[i]++;
                }
            }
        }
        return result;
    }
}

class Person {
    private final int WEIGHT;
    private final int HEIGHT;

    public Person(int weight, int height) {
        validateInput(weight, height);
        WEIGHT = weight;
        HEIGHT = height;
    }

    private void validateInput(int weight, int height) {
        if (weight < 10 || height < 10 || weight > 200 || height > 200) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public int compareBody(Person target) {
        if (WEIGHT > target.WEIGHT && HEIGHT > target.HEIGHT) {
            return 1;
        }
        if (WEIGHT < target.WEIGHT && HEIGHT < target.HEIGHT) {
            return -1;
        }
        return 0;
    }
}
