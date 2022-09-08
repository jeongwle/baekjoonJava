package baekjoon.반복문.FastAPlusB;

import java.io.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        final Case CASE = new Case(toInt(readLine()));
        for (int i = 0; i < CASE.getNumber(); i++) {
            String[] input = splitSpace(readLine());
            final Number A = new Number(toInt(input[0]));
            final Number B = new Number(toInt(input[1]));
            printResult(add(A.getNumber(), B.getNumber()));
        }
        closeBuffer();
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }

    static String[] splitSpace(String input) {
        return input.split(" ");
    }

    static int add(int num1, int num2) {
        return num1 + num2;
    }

    static String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    static void printResult(int result) throws IOException {
        bufferedWriter.write(result + "\n");
    }

    static void closeBuffer() throws IOException {
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}

class Number {
    private final int number;

    Number(int number) {
        if (!validateNumber(number)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.number = number;
    }

    private boolean validateNumber(int number) {
        return (number >= 1 && number <= 1_000);
    }

    public int getNumber() {
        return this.number;
    }
}

class Case {
    private final int number;

    Case(int number) {
        if (!validateNumber(number)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.number = number;
    }

    private boolean validateNumber(int number) {
        return (number >= 0 && number <= 1_000_000);
    }

    public int getNumber() {
        return this.number;
    }
}