package baekjoon.단계4_일차원배열.최댓값;

import java.io.*;
import java.util.Arrays;

/*
백준 2562
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String[] input = new String[9];
        for (int i = 0; i < 9; i++) {
            input[i] = BufReader.readLine();
        }
        final Max max = new Max();
        max.setNumbers(input);
        max.printMaxAndIndex();
    }
}

class Max {
    private final Number[] numbers;

    Max() {
        numbers = new Number[9];
    }

    public void setNumbers(String[] input) {
        for (int i = 0; i < this.numbers.length; i++) {
            this.numbers[i] = new Number(toInt(input[i]));
        }
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private Number getMax() {
        Number[] temp = cloneNumbers();
        sort(temp);
        return temp[temp.length - 1];
    }

    private int findIndex(Number max) {
        int result = 0;
        while (this.numbers[result] != max) {
            result++;
        }
        return result + 1;
    }

    private Number[] cloneNumbers() {
        Number[] temp = new Number[9];
        System.arraycopy(this.numbers, 0, temp, 0, this.numbers.length);
        return temp;
    }

    private void sort(Number[] input) {
        Arrays.sort(input);
    }

    public void printMaxAndIndex() throws IOException {
        BufWriter.write(getMax() + "\n");
        BufWriter.write(findIndex(getMax()) + "\n");
        BufWriter.flush();
        BufWriter.close();
    }
}

class Number implements Comparable<Number>{
    private final int number;

    Number(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number <= 0 || number >= 100) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return this.number + "";
    }

    @Override
    public int compareTo(Number o) {
        return (this.number - o.getNumber());
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
