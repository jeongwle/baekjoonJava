package baekjoon.사단계_일차원배열.최소최대;

/*
백준 10818
 */

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        final int caseNum = toInt(BufReader.readLine());
        final String[] numbers = splitSpace(BufReader.readLine());
        final MinMax minMax = new MinMax(caseNum);
        minMax.setNumbers(numbers);
        minMax.printMinMax();
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
        bw.write(o + "");
    }

    public static void flush() throws IOException {
        bw.flush();
    }

    public static void close() throws IOException {
        bw.close();
    }
}

class Case {
    private final int CASE;

    Case(int number) {
        validateCase(number);
        this.CASE = number;
    }

    private void validateCase(int number) {
        if (number < 1 || number > 1_000_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public int getCASE() {
        return CASE;
    }
}

class Number implements Comparable<Number>{
    private final int number;

    Number(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < -1_000_000 || number > 1_000_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Number o) {
        return this.number - o.getNumber();
    }

    @Override
    public String toString() {
        return number + "";
    }
}

class MinMax {
    private final Number[] numbers;

    MinMax(int caseNum) {
        Case CASE = new Case(caseNum);
        this.numbers = new Number[CASE.getCASE()];
    }

    public void setNumbers(String[] input) {
        for (int i = 0; i < input.length; i++) {
            this.numbers[i] = new Number(toInt(input[i]));
        }
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    public void printMinMax() throws IOException {
        sortNaturalOrder();
        printMin();
        printMax();
        BufWriter.flush();
        BufWriter.close();
    }

    private void sortNaturalOrder() {
        Arrays.sort(this.numbers);
    }

    private void printMin() throws IOException {
        BufWriter.write(getFirst() + " ");
    }

    private void printMax() throws IOException {
        BufWriter.write(getLast() + "\n");
    }

    private Number getFirst() {
        return this.numbers[0];
    }

    private Number getLast() {
        return this.numbers[this.numbers.length - 1];
    }
}