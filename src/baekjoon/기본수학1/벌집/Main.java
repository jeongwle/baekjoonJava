package baekjoon.기본수학1.벌집;
/*
백준 2292
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final HoneyComb honeyComb = new HoneyComb(scanner.nextInt());
        System.out.println(honeyComb.getShortPath());
    }
}

class HoneyComb {
    private final int TARGET_ROOM_NUM;

    HoneyComb(int tRoomNum) {
        validateRoomNum(tRoomNum);
        TARGET_ROOM_NUM = tRoomNum;
    }

    private void validateRoomNum(int tRoomNum) {
        if (tRoomNum < 1 || tRoomNum > 1_000_000_000) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

    public int getShortPath() {
        int count = 1;
        int roundRange = 1; // 벌집 동그란 라인
        while (roundRange < TARGET_ROOM_NUM) {
            roundRange += count * 6;
            count++;
        }
        return count;
    }

}
