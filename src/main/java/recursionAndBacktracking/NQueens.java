package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        // initialize board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // hashing arrays
        int[] leftRow = new int[n];                 // rows
        int[] upperDiag = new int[2 * n - 1];       // (n - 1) + col - row
        int[] lowerDiag = new int[2 * n - 1];       // row + col

        List<List<String>> ans = new ArrayList<>();
        solve(0, board, ans, leftRow, upperDiag, lowerDiag, n);
        return ans;
    }

    private void solve(int col,
                       char[][] board,
                       List<List<String>> ans,
                       int[] leftRow,
                       int[] upperDiag,
                       int[] lowerDiag,
                       int n) {

        if (col == n) {
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0
                    && lowerDiag[row + col] == 0
                    && upperDiag[n - 1 + col - row] == 0) {

                // place queen
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiag[row + col] = 1;
                upperDiag[n - 1 + col - row] = 1;

                // recurse
                solve(col + 1, board, ans, leftRow, upperDiag, lowerDiag, n);

                // backtrack
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiag[row + col] = 0;
                upperDiag[n - 1 + col - row] = 0;
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }

    // quick test
    public static void main(String[] args) {
        NQueens solver = new NQueens();
        List<List<String>> solutions = solver.solveNQueens(4);
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}

