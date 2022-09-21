package baekjoon.삼단계_반복문.APlusB5;
/*
백준 10952
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        while (true) {
            String[] input = splitSpace(BufReader.readLine());
            if (isExitCode(input[0], input[1])) {
                BufWriter.clean();
                break;
            }
            BufWriter.write(toInt(input[0]) + toInt(input[1]));
        }
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static String[] splitSpace(String input) {
        return input.split(" ");
    }

    static boolean isExitCode(String input1, String input2) {
        return (input1.equals("0") && input2.equals("0"));
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
