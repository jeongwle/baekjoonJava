package baekjoon.기타.삼각형외우기10101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.parseInt(bf.readLine());
        int second = Integer.parseInt(bf.readLine());
        int third = Integer.parseInt(bf.readLine());

        int sum = first + second + third;
        if (sum != 180) {
            System.out.println("Error");
            return;
        }

        if (first == second && second == third) {
            System.out.println("Equilateral");
        } else if (first != second && second != third && first != third) {
            System.out.println("Scalene");
        } else {
            System.out.println("Isosceles");
        }
    }
}
