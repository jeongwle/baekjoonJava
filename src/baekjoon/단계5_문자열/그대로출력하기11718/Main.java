package baekjoon.단계5_문자열.그대로출력하기11718;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder answer = new StringBuilder();
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            answer.append(input)
                    .append("\n");
        }

        System.out.print(answer);
    }
}
