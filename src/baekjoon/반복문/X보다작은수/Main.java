package baekjoon.반복문.X보다작은수;
/*
백준 10871
 */
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] input = splitSpace(BufReader.readLine());
        final Input CASE = new Input(toInt(input[0]));
        final Input COMPARE_TARGET = new Input(toInt(input[1]));
        input = splitSpace(BufReader.readLine());
        for (int i = 0; i < CASE.getInput(); i++) {
            final Input INPUT_TARGET = new Input(toInt(input[i]));
            if (INPUT_TARGET.getInput() < COMPARE_TARGET.getInput()) {
                BufWriter.write(INPUT_TARGET.getInput() + " ");
            }
        }
        BufWriter.write("\n");
        BufWriter.clean();
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static String[] splitSpace(String input) {
        return input.split(" ");
    }
}

class Input {
    private final int input;

    Input(int input) {
        if (!validateInput(input)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.input = input;
    }

    private boolean validateInput(int input) {
        return (input >= 1 && input <= 10_000);
    }

    public int getInput() {
        return this.input;
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
        bw.write(o + "");
    }

    public static void clean() throws IOException {
        bw.flush();
        bw.close();
    }
}