package baekjoon.반복문.APlusB4;
/*
백준 10951
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] split;
        while (true) {
            String input = BufReader.readLine();
            if (input == null || input.isEmpty()) {
                BufWriter.clean();
                break;
            }
            split = splitSpace(input);
            BufWriter.write(toInt(split[0]) + toInt(split[1]));
        }
    }

    static String[] splitSpace(String input) {
        return input.split(" ");
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
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