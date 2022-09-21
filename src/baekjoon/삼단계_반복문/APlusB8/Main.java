package baekjoon.삼단계_반복문.APlusB8;

/*
백준 11022
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        final int CASE = toInt(BufReader.readLine());

        for (int i = 0; i < CASE; i++) {
            String[] input = splitSpace(BufReader.readLine());
            BufWriter.write(makeSentence(i + 1, input));
        }
        BufWriter.clean();
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static String[] splitSpace(String input) {
        return input.split(" ");
    }

    static String makeSentence(int caseNumber, String[] input) {
        int result = toInt(input[0]) + toInt(input[1]);
        return ("Case #" + caseNumber + ": " + input[0] + " + " + input[1] + " = " + result);
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

