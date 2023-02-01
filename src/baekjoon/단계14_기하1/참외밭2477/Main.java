package baekjoon.단계14_기하1.참외밭2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        final int YIELD = toInt(bf.readLine());
        Input[] inputs = new Input[6];
        HashMap<Integer, Integer> max = new HashMap<>();
        for (int i = 0; i < inputs.length; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int dir = toInt(st.nextToken());
            int length = toInt(st.nextToken());
            inputs[i] = new Input(dir, length);
            max.put(dir, length);
        }

        int bigWidth = Math.max(max.get(1), max.get(2));
        int bigHeight = Math.max(max.get(3), max.get(4));
        int bigRectangle = bigWidth * bigHeight;

        int smallWidth = 0;
        int smallHeight = 0;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].getLength() == bigWidth) {
                if (i == 0) {
                    smallHeight = bigHeight - Math.min(inputs[5].getLength(), inputs[i + 1].getLength());
                } else if (i == 5) {
                    smallHeight = bigHeight - Math.min(inputs[0].getLength(), inputs[i - 1].getLength());
                } else {
                    smallHeight = bigHeight - Math.min(inputs[i + 1].getLength(), inputs[i - 1].getLength());
                }
            }
            if (inputs[i].getLength() == bigHeight) {
                if (i == 0) {
                    smallWidth = bigWidth - Math.min(inputs[5].getLength(), inputs[i + 1].getLength());
                } else if (i == 5) {
                    smallWidth = bigWidth - Math.min(inputs[0].getLength(), inputs[i - 1].getLength());
                } else {
                    smallWidth = bigWidth - Math.min(inputs[i + 1].getLength(), inputs[i - 1].getLength());
                }
            }
        }
        int smallRectangle = smallWidth * smallHeight;
        System.out.println((bigRectangle - smallRectangle) * YIELD);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class Input {
    private final int direction;
    private final int length;

    public Input(int direction, int length) {
        this.direction = direction;
        this.length = length;
    }

    public int getDir() {
        return direction;
    }

    public int getLength() {
        return length;
    }
}


