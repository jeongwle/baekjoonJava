package baekjoon.구단계_정렬.나이순정렬10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numOfMembers = toInt(bf.readLine());
        String[] members = new String[numOfMembers];
        for (int i = 0; i < members.length; i++) {
            members[i] = bf.readLine();
        }
        SortByAge sba = new SortByAge(numOfMembers, members);
        sba.printResult();
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class SortByAge {
    private final String[] MEMBERS;
    private final String[] temp;

    public SortByAge(int numOfMembers, String[] members) {
        ValidateInput.validate(numOfMembers, members);
        MEMBERS = members;
        temp = new String[numOfMembers];
    }

    public void mergeSort(int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int cur = left;

        while (i <= mid && j <= right) {
            if (isLessOrEqual(MEMBERS[i], MEMBERS[j])) {
                temp[cur++] = MEMBERS[i++];
            } else {
                temp[cur++] = MEMBERS[j++];
            }
        }

        while (i <= mid) {
            temp[cur++] = MEMBERS[i++];
        }

        int k = left;
        while (k < cur) {
            MEMBERS[k] = temp[k];
            k++;
        }
    }

    private boolean isLessOrEqual(String first, String second) {
        StringTokenizer st = new StringTokenizer(first, " ");
        StringTokenizer st2 = new StringTokenizer(second, " ");
        int firstAge = toInt(st.nextToken());
        int secondAge = toInt(st2.nextToken());
        return firstAge <= secondAge;
    }


    public void printResult() {
        StringBuilder sb = new StringBuilder();
        mergeSort(0, MEMBERS.length - 1);
        for (String member : MEMBERS) {
            sb.append(member)
                    .append("\n");
        }
        System.out.print(sb);
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

}

//class MergeSort {
//    private static String[] temp;
//
//    public static void mergeSort(String[] input, int left, int right) {
//        temp = new String[input.length];
//        int mid;
//        if (left < right) {
//            mid = (left + right) / 2;
//            mergeSort(input, left, mid);
//            mergeSort(input, mid + 1, right);
//            merge(input, left, mid, right);
//        }
//    }
//
//    private static void merge(String[] input, int left, int mid, int right) {
//        int i = left;
//        int j = mid + 1;
//        int cur = left;
//
//        while (i <= mid && j <= right) {
//            if (isLessOrEqual(input[i], input[j])) {
//                temp[cur++] = input[i++];
//            } else {
//                temp[cur++] = input[j++];
//            }
//        }
//
//        while (i <= mid) {
//            temp[cur++] = input[i++];
//        }
//
//        int k = left;
//        while (k < cur) {
//            input[k] = temp[k];
//            k++;
//        }
//    }
//
//    private static boolean isLessOrEqual(String first, String second) {
//        StringTokenizer st = new StringTokenizer(first, " ");
//        StringTokenizer st2 = new StringTokenizer(second, " ");
//        int firstAge = toInt(st.nextToken());
//        int secondAge = toInt(st2.nextToken());
//        return firstAge <= secondAge;
//    }
//
//    private static int toInt(String input) {
//        return Integer.parseInt(input);
//    }
//}

class ValidateInput {
    public static void validate(int numOfMember, String[] members) {
        if (numOfMember != members.length) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        validateNum(numOfMember);
        validateMember(members);
    }

    private static void validateNum(int numOfMember) {
        if (numOfMember < 1 || numOfMember > 100_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private static void validateMember(String[] members) {
        int age;
        String name;
        for (String member : members) {
            StringTokenizer st = new StringTokenizer(member, " ");
            age = toInt(st.nextToken());
            name = st.nextToken();
            validateAge(age);
            validateName(name);
        }
    }

    private static void validateAge(int age) {
        if (age < 1 || age > 200) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private static void validateName(String name) {
        StringTokenizer st = new StringTokenizer(
                name, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        );
        int length = name.length();
        if (st.hasMoreTokens() || length > 100) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
