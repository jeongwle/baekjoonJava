package baekjoon.클래스.Hashing15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> alphabet = new HashMap<>();
        char c = 'a';
        for (int i = 1; i < 27; i++) {
            alphabet.put(c, i);
            c++;
        }

        bf.readLine();
        String input = bf.readLine();
        long sum = 0;
        long pow = 1;
        for (int i = 0; i < input.length(); i++) {
            Integer number = alphabet.get(input.charAt(i));
            sum += ((long) number * pow) % 1234567891;
            pow = (pow * 31) % 1234567891;
        }
        sum %= 1234567891;
        System.out.println(sum);
    }
}
