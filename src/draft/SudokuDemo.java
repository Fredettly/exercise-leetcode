package draft;

import java.util.Arrays;

/**
 * Created by xwx_ on 2020/7/10
 */
public class SudokuDemo {
    public static void main(String[] args) {
        SudokuDemo solution = new SudokuDemo();
        int[][] input = new int[][] {
                {0,0,0,0,0,3},
                {0,0,3,6,0,0},
                {0,0,0,0,1,2},
                {5,1,0,0,0,0},
                {0,0,6,2,0,0},
                {4,0,0,0,0,0}
        };
        solution.sudokuSolver(input);
        solution.printResult(input);
    }

    private void printResult(int[][] output) {
        for (int[] i : output) {
            System.out.println(Arrays.toString(i));
        }
    }

    private void sudokuSolver(int[][] board) {
        dfs(board, 0, 0);
    }

    private boolean dfs(int[][] board, int row, int col) {
        if (row == 6) {
            return true;
        }
        for (int i = row; i < 6; i++, col = 0) {
            for (int j = col; j < 6; j++) {
                if (board[i][j] != 0) {
                    continue;
                }
                for (int k = 1; k <= 6; k++) {
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if (dfs(board, row, col + 1)) {
                            return true;
                        }
                        board[i][j] = 0;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int i, int j, int k) {
        for (int m = 0; m < 6; m++) {
            if (board[i][m] == k || board[m][j] == k) {
                return false;
            }
        }
        return true;
    }
}
