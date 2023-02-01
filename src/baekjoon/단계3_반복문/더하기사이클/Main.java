package baekjoon.단계3_반복문.더하기사이클;

/*
백준 1110
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final PlusCycle plusCycle = new PlusCycle(toInt(BufReader.readLine()));
        BufWriter.write(plusCycle.getCycle());
        BufWriter.clean();
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class PlusCycle {
    private final int NUMBER;
    private int count;

    PlusCycle(int number) {
        if (!validateNumber(number)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.NUMBER = number;
        this.count = 1;
    }

    private boolean validateNumber(int number) {
        return (number >= 0 && number <= 99);
    }

    public int getCycle() {
        int temp = this.getNextNumber(this.NUMBER);
        while (temp != this.NUMBER) {
            temp = this.getNextNumber(temp);
            count++;
        }
        return count;
    }

    private int getNextNumber(int input) {
        return ((input % 10) * 10 + (input / 10 + input % 10) % 10);
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