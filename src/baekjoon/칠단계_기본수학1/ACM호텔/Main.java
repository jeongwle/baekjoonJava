package baekjoon.칠단계_기본수학1.ACM호텔;
/*
백준 10250
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        final int CASE = toInt(bf.readLine());
        for (int i = 0; i < CASE; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            final int HEIGHT = toInt(st.nextToken());
            final int WIDTH = toInt(st.nextToken());
            final int NUMBER = toInt(st.nextToken());

            final RoomAssigner roomAssigner = new RoomAssigner(WIDTH, HEIGHT, NUMBER);
            System.out.println(roomAssigner.assignRoom());
        }
    }

    static int toInt(String input) {
        return Integer.parseInt(input);
    }
}

class RoomAssigner {
    private final int HOTEL_HEIGHT;
    private final int GUEST_NUMBER;

    RoomAssigner(int width, int height, int num) {
        validateInput(width, height, num);
        HOTEL_HEIGHT = height;
        GUEST_NUMBER = num;
    }

    private void validateInput(int hWidth, int hHeight , int gNum) {
        if (hWidth < 1 || hHeight < 1 || hWidth > 99 || hHeight > 99) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        if (gNum < 1 || gNum > (hWidth * hHeight)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public String assignRoom() {
        return getFloor() + getRoomNumber();
    }

    private String getRoomNumber() {
        /*
         나머지로 방번호를 구하기 위해서는 GUEST_NUMBER에서 1을 빼주어야 한다.
         GUEST_NUMBER == HOTEL_HEIGHT일 때 방번호가 제대로 나오게 하기 위해.
         */
        int RoomNumber = (GUEST_NUMBER - 1) / HOTEL_HEIGHT + 1;
        // 방 번호가 한자리 수 이면 앞에 0을 붙여준다.
        if (RoomNumber / 10 == 0) {
            return "0" + RoomNumber;
        }
        return String.valueOf(RoomNumber);
    }

    // 몇층인지 구하자
    private String getFloor() {
        int remainder = GUEST_NUMBER % HOTEL_HEIGHT;
        // 나머지가 없으면 꼭대기층
        if (remainder == 0) {
            return String.valueOf(HOTEL_HEIGHT);
        }
        return String.valueOf(remainder);
    }
}
