package baekjoon.십육단계_백트래킹.NQueen9663;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int chessBoardSize = Integer.parseInt(bf.readLine());

        int[] chessBoard = new int[chessBoardSize];
        nQueen(chessBoard, 0);
        System.out.println(count);
    }

    public static void nQueen(int[] chessBoard, int depth) {
        if (depth == chessBoard.length) {
            count++;
            return;
        }
        for (int i = 0; i < chessBoard.length; i++) {
            chessBoard[depth] = i;
            if (isValidate(chessBoard, depth)) {
                nQueen(chessBoard, depth + 1);
            }
        }
    }

    public static boolean isValidate(int[] chessBoard, int depth) {
        for (int i = 0; i < depth; i++) {
            // 값은 행, 행의 위치가 같으면 안된다.
            if (chessBoard[depth] == chessBoard[i]) {
                return false;
                // 열의 차이와 행의 차이가 같으면 대각선에 있다.
            } else if (Math.abs(depth - i) == Math.abs(chessBoard[depth] - chessBoard[i])) {
                return false;
            }
        }
        return true;
    }
}

    // 시간초과 및 망한 코드
//    private static int[][] chessBoard;
//    private static boolean[] rowVisit;
//    private static boolean[] colVisit;
//    private static int result = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = toInt(bf.readLine());
//
//        chessBoard = new int[N][N];
//        rowVisit = new boolean[N];
//        colVisit = new boolean[N];
//        dfs(N, 0);
//
//        System.out.println(result);
//    }
//
//    public static int toInt(String input) {
//        return Integer.parseInt(input);
//    }
//
//    public static void dfs(int N, int depth) {
//        if (N == depth && isValidate(N)) {
//            result++;
//            return;
//        }
//
//
//        Loop1 : for (int i = 0; i < N; i++) {
//            for (int j = 0; j <= N - 2; j++) {
//                if (depth == j && i == j + 1) {
//                    break Loop1;
//                }
//            }
//            for (int j = 0; j < N; j++) {
//                if (!rowVisit[i] && !colVisit[j]) {
//                    rowVisit[i] = colVisit[j] = true;
//                    chessBoard[i][j] = 1;
//                    dfs(N, depth + 1);
//                    chessBoard[i][j] = 0;
//                    rowVisit[i] = colVisit[j] = false;
//                }
//            }
//        }
//    }
//
//    public static boolean isValidate(int N) {
//        return (checkReverseSlash(N) && checkSlash(N));
//    }
//
//    public static boolean checkReverseSlash(int N) {
//        int count = 0;
//        for (int i = 0; i < N - 1; i++) {
//            for (int j = 0; j < N - 1; j++) {
//                if (chessBoard[i][j] == 1) {
//                    int iTemp = i + 1;
//                    int jTemp = j + 1;
//                    while (iTemp < N  && jTemp < N ) {
//                        if (chessBoard[iTemp][jTemp] == 1) {
//                            count++;
//                        }
//                        iTemp++;
//                        jTemp++;
//                    }
//                }
//            }
//        }
//        return count == 0;
//    }
//
//    public static boolean checkSlash(int N) {
//        for (int i = 0; i <= 2 * (N - 1); i++) {
//            int count = 0;
//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < N; k++) {
//                    if (j + k == i && chessBoard[j][k] == 1) {
//                        count++;
//                    }
//                }
//            }
//            if (count >= 2) {
//                return false;
//            }
//        }
//        return true;
//    }


//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//
//    public static int[] arr;
//    public static int N;
//    public static int count = 0;
//
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//        N = in.nextInt();
//        arr = new int[N];
//
//        nQueen(0);
//        System.out.println(count);
//
//    }
//
//    public static void nQueen(int depth) {
//        // 모든 원소를 다 채운 상태면 count 증가 및 return
//        if (depth == N) {
//            System.out.println("arr = " + Arrays.toString(arr));
//            count++;
//            return;
//        }
//
//        for (int i = 0; i < N; i++) {
//            arr[depth] = i;
//            // 놓을 수 있는 위치일 경우 재귀호출
//            if (arr[0] == 2 && arr[1] == 0 && depth == 2) {
//                System.out.println("i = " + i);
//                System.out.println("Possibility(depth) = " + Possibility(depth));
//                System.out.println();
//            }
//            if (Possibility(depth)) {
//                nQueen(depth + 1);
//            }
//        }
//
//    }
//
//    public static boolean Possibility(int col) {
//
//        for (int i = 0; i < col; i++) {
//            // 해당 열의 행과 i열의 행이 일치할경우 (같은 행에 존재할 경우)
//            if (arr[col] == arr[i]) {
//                return false;
//            }
//
//            /*
//             * 대각선상에 놓여있는 경우
//             * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
//             */
//            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//}
