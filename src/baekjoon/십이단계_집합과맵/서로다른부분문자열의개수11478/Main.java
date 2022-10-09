package baekjoon.십이단계_집합과맵.서로다른부분문자열의개수11478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        Set<String> partialString = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                partialString.add(input.substring(i, j));
            }
        }

        System.out.println(partialString.size());
    }
}
