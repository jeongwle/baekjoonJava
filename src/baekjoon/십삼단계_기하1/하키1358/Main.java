package baekjoon.십삼단계_기하1.하키1358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        final int WIDTH = toInt(st.nextToken());
        final int HEIGHT = toInt(st.nextToken());
        final int START_X = toInt(st.nextToken());
        final int START_Y = toInt(st.nextToken());
        final int NUMBER_OF_PERSON = toInt(st.nextToken());

        Recntangle r = new Recntangle(START_X, START_Y, WIDTH, HEIGHT);
        Circle left = new Circle(HEIGHT / 2, START_X, START_Y + HEIGHT / 2);
        Circle right = new Circle(HEIGHT / 2, START_X + WIDTH, START_Y + HEIGHT / 2);

        int result = 0;
        for (int i = 0; i < NUMBER_OF_PERSON; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int x = toInt(st.nextToken());
            int y = toInt(st.nextToken());

            if (r.isInside(x, y) || left.isInside(x, y) || right.isInside(x, y)) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class Recntangle {
    private final int startX;
    private final int startY;
    private final int width;
    private final int height;

    public Recntangle(int startX, int startY, int width, int height) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
    }


    public boolean isInside(int x, int y) {
        return (startX <= x && x <= startX + width) && (startY <= y && y <= startY + height);
    }
}

class Circle {
    private final int radius;
    private final int startX;
    private final int startY;

    public Circle(int radius, int startX, int startY) {
        this.radius = radius;
        this.startX = startX;
        this.startY = startY;
    }

    public boolean isInside(int x, int y) {
        int lengthX = Math.abs(startX - x);
        int lengthY = Math.abs(startY - y);
        double distancePow = Math.pow(lengthX, 2) + Math.pow(lengthY, 2);
        return (distancePow <= Math.pow(radius, 2));
    }
}
