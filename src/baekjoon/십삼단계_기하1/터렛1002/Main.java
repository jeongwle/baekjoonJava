package baekjoon.십삼단계_기하1.터렛1002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        class Employee {
            final int posX;
            final int posY;
            final int distance;

            public Employee(int posX, int posY, int distance) {
                this.posX = posX;
                this.posY = posY;
                this.distance = distance;
            }
        }
        Scanner scanner = new Scanner(System.in);
        String firstInput = scanner.nextLine();
        final int CASE = Integer.parseInt(firstInput);

        for (int i = 0; i < CASE; i++) {
            String input = scanner.nextLine();
            String[] data = input.split(" ");

            Employee lee = new Employee(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            Employee baek = new Employee(Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]));

            double distFromBaekToLee = getDistance(lee.posX, lee.posY, baek.posX, baek.posY);
            if (lee.distance == baek.distance && lee.posX == baek.posX && lee.posY == baek.posY) {
                System.out.println("-1");
            } else {
                int distAbs = Math.abs(lee.distance - baek.distance);
                if (distFromBaekToLee > lee.distance + baek.distance || distFromBaekToLee < distAbs) {
                    System.out.println("0");
                } else if (distFromBaekToLee == lee.distance + baek.distance || distFromBaekToLee == distAbs) {
                    System.out.println("1");

                } else {
                    System.out.println("2");
                }
            }
        }
    }
    static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
