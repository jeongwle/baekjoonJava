package baekjoon.십사단계_정수론및조합론.약수1037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int number = toInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        ArrayList<Integer> input = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            input.add(toInt(st.nextToken()));
        }
        Collections.sort(input);
        if (input.size() == 1) {
            System.out.println((int)Math.pow(input.get(0), 2));
        } else {
            System.out.println(input.get(0) * input.get(input.size() - 1));
        }
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
