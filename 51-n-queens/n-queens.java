// apna college
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static boolean issafe(char board[][], int row, int col) {
        // Vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Diagonal up-left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonal up-right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void nqueens(char board[][], int row, List<List<String>> solutions) {
        // Base case
        if (row == board.length) {
            solutions.add(constructSolution(board));
            return;
        }

        // Column loop
        for (int j = 0; j < board.length; j++) {
            if (issafe(board, row, j)) {
                board[row][j] = 'Q'; // Place the queen
                nqueens(board, row + 1, solutions); // Recursive call
                board[row][j] = '.'; // Backtracking step
            }
        }
    }

    private List<String> constructSolution(char board[][]) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
            }
            solution.add(sb.toString());
        }
        return solution;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char board[][] = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; // Use '.' for empty spaces
            }
        }

        nqueens(board, 0, solutions);
        return solutions;
    }

    public static void main(String args[]) {
        int n = 4; // Change this to any value you want to test
        if (n == 2 || n == 3) {
            System.out.println("No solution exists for n = " + n);
            return;
        }

        Solution solution = new Solution();
        List<List<String>> results = solution.solveNQueens(n);
        for (List<String> res : results) {
            for (String row : res) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}