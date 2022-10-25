package baekjoon.칠단계_문자열.크로아티아알파벳;
/*
백준 2941
 */


import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final CroatiaAlpha croatiaAlpha = new CroatiaAlpha(scanner.nextLine());
        int result = croatiaAlpha.countWord();
        System.out.println(result);
    }

}

class CroatiaAlpha {
    // dz= 보다 z=가 앞에 있으먼 안된다.
    static final String[] CROATIA_ALPHA = {
            "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
    };

    private final String input;

    CroatiaAlpha(String input) {
        validateInput(input);
        this.input = input;
    }

    private void validateInput(String input) {
        StringTokenizer st = new StringTokenizer(input, "abcdefghijklmnopqrstuvwxyz-=");
        if (st.hasMoreTokens()) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    private int countRestWord(String input) {
        int result = 0;
        StringTokenizer st = new StringTokenizer(input, "abcdefghijklmnopqrstuvwxyz!", true);
        while (st.hasMoreTokens()) {
            if (Objects.equals(st.nextToken(), "!")) {
                continue;
            }
            result++;
        }
        return result;
    }

    public int countWord() {
        int result = 0;
        String temp = this.input;
        for (String regex : CROATIA_ALPHA) {
            StringBuffer sb = new StringBuffer();
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(temp);
            while (m.find()) {
                m.appendReplacement(sb, "!"); // 처음에 빈문자열로 했으나 앞 뒤가 합쳐지며 크로아티아알파벳이 되는 경우가 생겨서 수정
                result++;
            }
            m.appendTail(sb);
            temp = String.valueOf(sb);
        }
        result += countRestWord(temp);
        return result;
    }
}
