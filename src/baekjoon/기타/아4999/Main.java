package baekjoon.기타.아4999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String myAh = bf.readLine();
        String doctorAh = bf.readLine();

        if (myAh.lastIndexOf('a') >= doctorAh.lastIndexOf('a')) {
            System.out.println("go");
            return;
        }
        System.out.println("no");
    }
}
