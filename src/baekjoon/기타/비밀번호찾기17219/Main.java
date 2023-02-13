package baekjoon.기타.비밀번호찾기17219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int numberOfInput = Integer.parseInt(st.nextToken());
        int numberOfQuestion = Integer.parseInt(st.nextToken());

        HashMap<String, String> passwords = new HashMap<>();

        for (int i = 0; i < numberOfInput; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            passwords.put(st.nextToken(), st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfQuestion; i++) {
            sb.append(passwords.get(bf.readLine()))
                    .append("\n");
        }
        System.out.print(sb);
    }
}
