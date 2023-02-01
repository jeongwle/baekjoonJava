package baekjoon.십구단계_그리디알고리즘.ATM11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfPerson = Integer.parseInt(bf.readLine());

        int[] persons = new int[numberOfPerson];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < persons.length; i++) {
            persons[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(persons);
        int sum = 0;
        int result = 0;
        for (int miniute : persons) {
            sum += miniute;
            result += sum;
        }
        System.out.println(result);
    }
}
