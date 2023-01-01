package baekjoon.기타.팀이름정하기1296;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int L = 0;
    private static int O = 0;
    private static int V = 0;
    private static int E = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String yeondooName = bf.readLine();

        int N = Integer.parseInt(bf.readLine());
        int max = -1;
        String result = "";
        for (int i = 0; i < N; i++) {
            count(yeondooName);
            String team = bf.readLine();
            count(team);
            if (max == calculate() && result.compareTo(team) > 0) {
                result = team;
            }
            if (max < calculate()) {
                max = calculate();
                result = team;
            }
            L = 0;
            O = 0;
            V = 0;
            E = 0;
        }
        System.out.println(result);

    }

    private static int calculate() {
        return ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
    }

    private static void count(String name) {
        for (char c : name.toCharArray()) {
            switch (c) {
                case 'L':
                    L++;
                    break;
                case 'O':
                    O++;
                    break;
                case 'V':
                    V++;
                    break;
                case 'E':
                    E++;
                    break;
            }
        }
    }
}
