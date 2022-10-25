package baekjoon.십삼단계_집합과맵.문자열집합14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int collectionNum = toInt(st.nextToken());
        int inputNum = toInt(st.nextToken());
        HashSet<String> collection = new HashSet<>();

        for (int i = 0; i < collectionNum; i++) {
            collection.add(bf.readLine());
        }

        String input;
        int count = 0;
        for (int i = 0; i < inputNum; i++) {
            input = bf.readLine();
            if (input == null) {
                break;
            }
            if (collection.contains(input)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
