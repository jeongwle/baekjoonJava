package baekjoon.음계2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        String[] origin = new String[8];
        String[] temp = new String[8];

        int index = 0;
        while (st.hasMoreTokens()) {
            String number = st.nextToken();
            origin[index] = number;
            temp[index] = number;
            index++;
        }

        Arrays.sort(temp);
        if (Arrays.equals(origin, temp)) {
            System.out.println("ascending");
            return;
        }
        Arrays.sort(temp, Collections.reverseOrder());
        if (Arrays.equals(origin, temp)) {
            System.out.println("descending");
            return;
        }
        System.out.println("mixed");
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

}
