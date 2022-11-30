package baekjoon.십육단계_백트래킹.스도쿠2580;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] sudokuBoard = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < sudokuBoard.length; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

            for (int j = 0; j < sudokuBoard[i].length; j++) {
                sudokuBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    public static void sudoku(int row, int col) {
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            for (int[] rows : sudokuBoard) {
                for (int rowCol : rows) {
                    System.out.print(rowCol + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (sudokuBoard[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (ifPossible(row, col, i)) {
                    sudokuBoard[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            sudokuBoard[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);
    }

    public static boolean ifPossible(int row, int col, int value) {

        // 행 검사
        for (int i = 0; i < 9; i++) {
            if (sudokuBoard[row][i] == value) {
                return false;
            }
        }

        // 열 검사
        for (int i = 0; i < 9; i++) {
            if (sudokuBoard[i][col] == value) {
                return false;
            }
        }

        // 3 X 3 박스 검사
        for (int i = 3 * (row / 3); i < 3 * (row / 3 + 1); i++) {
            for (int j = 3 * (col / 3); j < 3 * (col / 3 + 1); j++) {
                if (sudokuBoard[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}

/* 시간초과 코드 */
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    private static final int[][] sdokuBoard = new int[9][9];
//    private static int zeroCount;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//
//        for (int i = 0; i < sdokuBoard.length; i++) {
//            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
//
//            for (int j = 0; j < sdokuBoard[i].length; j++) {
//                sdokuBoard[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        zeroCount = getZeroCount();
//        sdoku();
//        printResult();
//    }
//
//    public static void sdoku() {
//        if (zeroCount == 0) {
//            return;
//        }
//        for (int i = 0; i < sdokuBoard.length; i++) {
//            for (int j = 0; j < sdokuBoard[i].length; j++) {
//                if (sdokuBoard[i][j] == 0) {
//                    if (!rowCheck(i, j) && !colCheck(i, j)) {
//                        squareCheck(i, j);
//                    }
//                }
//            }
//        }
//        sdoku();
//    }
//
//    public static boolean rowCheck(int row, int col) {
//        List<Integer> list = generateList();
//        List<Integer> remove = new ArrayList<>();
//        for (int i = 0; i < sdokuBoard[row].length; i++) {
//            int target = sdokuBoard[row][i];
//            list.forEach(element -> {
//                if (element == target) {
//                    remove.add(element);
//                }
//            });
//        }
//        list.removeAll(remove);
//        if (list.size() == 1) {
//            sdokuBoard[row][col] = list.get(0);
//            zeroCount--;
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean colCheck(int row, int col) {
//        List<Integer> list = generateList();
//        List<Integer> remove = new ArrayList<>();
//        for (int[] ints : sdokuBoard) {
//            int target = ints[col];
//            list.forEach(element -> {
//                if (element == target) {
//                    remove.add(element);
//                }
//            });
//        }
//        list.removeAll(remove);
//        if (list.size() == 1) {
//            sdokuBoard[row][col] = list.get(0);
//            zeroCount--;
//            return true;
//        }
//        return false;
//    }
//
//    public static void squareCheck(int row, int col) {
//        List<Integer> list = generateList();
//        List<Integer> remove = new ArrayList<>();
//        for (int i = 3 * (row / 3); i < 3 * (row / 3 + 1); i++) {
//            for (int j = 3 * (col / 3); j < 3 * (col / 3 + 1); j++) {
//                int target = sdokuBoard[i][j];
//                list.forEach((element) -> {
//                    if (element == target) {
//                        remove.add(element);
//                    }
//                });
//            }
//        }
//        list.removeAll(remove);
//        if (list.size() == 1) {
//            sdokuBoard[row][col] = list.get(0);
//            zeroCount--;
//        }
//    }
//
//    public static int getZeroCount() {
//        int count = 0;
//        for (int[] row : sdokuBoard) {
//            for (int rowCol : row) {
//                if (rowCol == 0) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    public static void printResult() {
//        StringBuilder sb = new StringBuilder();
//        for (int[] row : sdokuBoard) {
//            for (int rowCol : row) {
//                sb.append(rowCol)
//                        .append(" ");
//            }
//            sb.append("\n");
//        }
//        System.out.print(sb);
//    }
//
//    public static List<Integer> generateList() {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i < 10; i++) {
//            list.add(i);
//        }
//        return list;
//    }
//}
