package baekjoon.삼단계_반복문.APlusB7;

/*
백준 11021
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        final int CASE = toInt(BufReader.readLine());

        for (int i = 0; i < CASE; i++) {
            String[] input = splitSpace(BufReader.readLine());
            int result = add(toInt(input[0]), toInt(input[1]));
            BufWriter.write(addPrefix(i + 1, result));
        }
        BufWriter.clean();
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static String[] splitSpace(String input) {
        return input.split(" ");
    }

    static String addPrefix(int caseNumber, int result) {
        return ("Case #" + caseNumber + ": " + result);
    }

    static int add(int num1, int num2) {
        return (num1 + num2);
    }
}

class BufReader {
    static private final BufferedReader br;
    static {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static String readLine() throws IOException {
        return br.readLine();
    }
}

class BufWriter {
    static private final BufferedWriter bw;
    static {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void write(Object o) throws IOException {
        bw.write(o + "\n");
    }

    public static void clean() throws IOException {
        bw.flush();
        bw.close();
    }
}
