package baekjoon.기타.너의평점은25206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    private static final HashMap<String, Float> majorScore = new HashMap<>();
    private static final int numberOfSubject = 20;

    static {
        majorScore.put("A+", 4.5f);
        majorScore.put("A0", 4.0f);
        majorScore.put("B+", 3.5f);
        majorScore.put("B0", 3.0f);
        majorScore.put("C+", 2.5f);
        majorScore.put("C0", 2.0f);
        majorScore.put("D+", 1.5f);
        majorScore.put("D0", 1.0f);
        majorScore.put("F", 0.0f);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        float sum = 0.0f;
        float scoreSum = 0.0f;
        for (int i = 0; i < numberOfSubject; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            st.nextToken();
            // 4.5, 4.0 ... etc
            double score = Double.parseDouble(st.nextToken());
            // A+, A0 ... etc
            String grade = st.nextToken();
            if (grade.equals("P")) {
                continue;
            }
            sum += score * majorScore.get(grade);
            scoreSum += score;
        }
        System.out.println(sum / scoreSum);
    }
}
