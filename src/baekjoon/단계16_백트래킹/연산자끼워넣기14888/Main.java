package baekjoon.단계16_백트래킹.연산자끼워넣기14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] numbers;
    private static final List<String> operators = new ArrayList<>();
    private static final List<List<String>> operatorList = new ArrayList<>();
    private static boolean[] visit;
    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        /* 입력 받기 */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bf.readLine());
        numbers = new int[size];

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            int number = Integer.parseInt(st.nextToken());
            switch (i) {
                case 0: {
                    setOperators(number, "add");
                    break;
                }
                case 1: {
                    setOperators(number, "subtract");
                    break;
                }
                case 2: {
                    setOperators(number, "multiply");
                    break;
                }
                case 3: {
                    setOperators(number, "divide");
                    break;
                }
            }
        }
        /* 입력 받기 끝 */

        visit = new boolean[operators.size()];
        makeOperator(0, new String[size - 1]);
        calculate();
        System.out.println(MAX);
        System.out.println(MIN);

    }

    public static void makeOperator(int depth, String[] element) {
        if (depth == operators.size()) {
            operatorList.add(new ArrayList<>(Arrays.asList(element)));
            return;
        }

        for (int i = 0; i < operators.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                element[depth] = operators.get(i);
                makeOperator(depth + 1, element);
                visit[i] = false;
            }
        }
    }

    public static void setOperators(int number, String text) {
        for (int i = 0; i < number; i++) {
            operators.add(text);
        }
    }

    public static void calculate() {
        for (List<String> operator : operatorList) {
            int index = 1;
            int value = numbers[0];

            for (String oper : operator) {
                int target = numbers[index];
                switch (oper) {
                    case "add": {
                        value += target;
                        break;
                    }
                    case "subtract": {
                        value -= target;
                        break;
                    }
                    case "multiply": {
                        value *= target;
                        break;
                    }
                    case "divide" : {
                        if ((value < 0 && target > 0) || (value > 0 && target < 0)) {
                            value = (Math.abs(value) / Math.abs(target)) * -1;
                        } else {
                            value /= target;
                        }
                        break;
                    }
                }
                index++;
            }

            if (MAX < value) {
                MAX = value;
            }
            if (MIN > value) {
                MIN = value;
            }
        }
    }

}
