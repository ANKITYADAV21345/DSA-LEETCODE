//shradha didi

class Solution {
    
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        // Base case
        if (row == 9 && col==0) return true;

        // Next cell
        int nextRow = row, nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // Skip filled cells
        if (board[row][col] != '.') {
            return solve(board, nextRow, nextCol);
        }

        // Try digits 1 to 9
        for (char digit = '1'; digit <= '9'; digit++) {
            if (isSafe(board, row, col, digit)) {
                board[row][col] = digit;
                if (solve(board, nextRow, nextCol)) {
                    return true;
                }
                board[row][col] = '.'; // backtrack
            }
        }

        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, char digit) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit || board[i][col] == digit) {
                return false;
            }
        }

        // Check 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }
}