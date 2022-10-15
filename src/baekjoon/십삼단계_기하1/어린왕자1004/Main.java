package baekjoon.십삼단계_기하1.어린왕자1004;

/*
 출발점과 도착점을 둘러싸고 있는 원의 개수를 구해야 한다고 생각을 하였음.
 하지만 같은 원에 둘다 존재한다면 result를 ++해줄 필요가 없다는 것이 틀리고 나서 생각하게 됨.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int CASE = Integer.parseInt(scanner.nextLine());
        String[] input;

        for (int i = 0; i < CASE; i++) {
            int result = 0;
            input = scanner.nextLine().split(" ");
            Point depart = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            Point arrival = new Point(Integer.parseInt(input[2]), Integer.parseInt(input[3]));

            final int PLANET_COUNT = Integer.parseInt(scanner.nextLine());
            Planet[] planets = new Planet[PLANET_COUNT];
            for (int j = 0; j < PLANET_COUNT; j++) {
                input = scanner.nextLine().split(" ");
                planets[j] = new Planet(
                        new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1])), Integer.parseInt(input[2])
                );
                if (planets[j].isInside(depart) && planets[j].isInside(arrival)) {
                    continue;
                }
                if (planets[j].isInside(depart) || planets[j].isInside(arrival)) {
                    ++result;
                }
            }
            System.out.println(result);
        }
    }
}

class Planet {
    Point center;
    int radius;

    Planet(Point p, int radius) {
        this.center = p;
        this.radius = radius;
    }

    int getDistance(Point target) {
        return (int) Math.sqrt(
                Math.pow(this.center.x - target.x, 2) + Math.pow(this.center.y - target.y, 2)
        );
    }

    boolean isInside(Point target) {
        return this.radius > this.getDistance(target);
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}