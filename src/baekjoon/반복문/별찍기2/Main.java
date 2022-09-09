package baekjoon.반복문.별찍기2;

/*
백준 2439
 */
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int N = toInt(BufReader.readLine());
        if (!validateN(N)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        for (int i = 0; i < N; i++) {
            BufWriter.write(makeStar(makeSpace(N - i - 1), i + 1));
        }
        BufWriter.clean();
    }

    static String makeSpace(int num) {
        String result = "";
        for (int i = 0; i < num; i++) {
            result += " ";
        }
        return result;
    }

    static String makeStar(String result, int num) {
        for (int i = 0; i < num; i++) {
            result += "*";
        }
        return result;
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static boolean validateN(int N) {
        return (N >= 1 && N <= 100);
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
