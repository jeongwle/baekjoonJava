package baekjoon.십단계_정렬.단어정렬1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numOfWords = toInt(bf.readLine());
        String[] words = new String[numOfWords];
        for (int i = 0; i < words.length; i++) {
            words[i] = bf.readLine();
        }
        WordSort ws = new WordSort(words, numOfWords);
        ws.printResult();
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class WordSort {
    private final String[] WORDS;
    private final HashMap<String, Boolean> CHECKER = new HashMap<>();

    public WordSort(String[] words, int numOfWords) {
        validateInput(words, numOfWords);
        WORDS = deleteDuplicate(words);
    }

    private String[] deleteDuplicate(String[] words) {
        ArrayList<String> temp = new ArrayList<>();
        for (String word : words) {
            if (CHECKER.containsKey(word)) {
                continue;
            }
            temp.add(word);
            CHECKER.put(word, true);
        }
        return temp.toArray(new String[0]);
    }

    private void validateInput(String[] words, int numOfWords) {
        if (words.length != numOfWords || numOfWords < 1 || numOfWords > 20000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        for (String word : words) {
            StringTokenizer st = new StringTokenizer(word, "abcdefghijklmnopqrstuvwxyz");
            if (word.length() > 50 || st.hasMoreTokens()) {
                throw new RuntimeException("잘못된 입력입니다.");
            }
        }
    }

    private void sortByLength() {
        SortByLength.msByLength(WORDS, 0, WORDS.length - 1);
    }

    private void sortWithSection() {
        int temp = 0;
        int length = WORDS[0].length();
        int i = 0;
        while (i < WORDS.length) {
            if (length != WORDS[i].length()) {
                sortByDictionary(temp, i - 1);
                temp = i;
                length = WORDS[i].length();
            }
            i++;
        }
        sortByDictionary(temp, i - 1);
    }

    private void sortByDictionary(int left, int right) {
        SortByDictionary.msByDictionary(WORDS, left, right);
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();
        sortByLength();
        sortWithSection();
        for (String word : WORDS) {
            sb.append(word)
                    .append("\n");
        }
        System.out.print(sb);
    }
}

class SortByLength {
    private static String[] temp;

    public static void msByLength(String[] input, int left, int right) {
        temp = new String[input.length];
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            msByLength(input, left, mid);
            msByLength(input, mid + 1, right);
            merge(input, left, mid, right);
        }
    }

    private static void merge(String[] input, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int cur = left;

        while (i <= mid && j <= right) {
            if (input[i].length() <= input[j].length()) {
                temp[cur++] = input[i++];
            } else {
                temp[cur++] = input[j++];
            }
        }

        while (i <= mid) {
            temp[cur++] = input[i++];
        }

        int k = left;
        while (k < cur) {
            input[k] = temp[k];
            k++;
        }
    }
}

class SortByDictionary {
    private static String[] temp;

    static void msByDictionary(String[] input, int left, int right) {
        temp = new String[input.length];
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            msByDictionary(input, left, mid);
            msByDictionary(input, mid + 1, right);
            merge(input, left, mid, right);
        }
    }

    private static void merge(String[] input, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int cur = left;

        while (i <= mid && j <= right) {
            if (input[i].compareTo(input[j]) < 0) {
                temp[cur++] = input[i++];
            } else {
                temp[cur++] = input[j++];
            }
        }

        while (i <= mid) {
            temp[cur++] = input[i++];
        }

        int k = left;
        while (k < cur) {
            input[k] = temp[k];
            k++;
        }
    }
}
