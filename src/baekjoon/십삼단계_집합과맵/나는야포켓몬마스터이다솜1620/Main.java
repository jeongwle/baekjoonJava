package baekjoon.십삼단계_집합과맵.나는야포켓몬마스터이다솜1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int numberOfList = toInt(st.nextToken()); // 도감에 저장된 목록의 수
        int numberOfInput = toInt(st.nextToken()); // 맞춰야 하는 문제의 수

        HashMap<String, String> pkmListNum = new HashMap<>();
        HashMap<String, String> pkmListName = new HashMap<>();
        String input;
        String number;
        for (int i = 1; i <= numberOfList; i++) {
            input = bf.readLine();
            number = String.valueOf(i);
            pkmListNum.put(number, input);
            pkmListName.put(input, number);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfInput; i++) {
            input = bf.readLine();
            if (isNumber(input)) {
                sb.append(pkmListNum.get(input));
            } else {
                sb.append(pkmListName.get(input));
            }
            sb.append("\n");
        }

        System.out.print(sb);
        /*
          밑에 주석친 부분은 시간초과 코드. 아무래도 for문이 두번 돌다보니 그런 것 같다.
         */

//        HashMap<String, String> pkmList = new HashMap<>();
//        for (int i = 1; i <= numberOfList; i++) {
//            pkmList.put(String.valueOf(i), bf.readLine());
//        }
//
//        String input;
//        Set<Map.Entry<String, String>> entries = pkmList.entrySet();
//
//        for (int i = 0; i < numberOfInput; i++) {
//            input = bf.readLine();
//            if (pkmList.containsKey(input)) {
//                System.out.println(pkmList.get(input));
//                continue;
//            }
//            if (pkmList.containsValue(input)) {
//                String finalInput = input;
//                Optional<Map.Entry<String, String>> entry1 = entries.stream()
//                        .filter(entry -> entry.getValue().equals(finalInput))
//                        .findAny();
//                entry1.ifPresent(entry -> System.out.println(entry.getKey()));
//            }
//        }
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static boolean isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
