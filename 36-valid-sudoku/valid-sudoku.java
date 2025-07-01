//CTO BHAIYA
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 9 sets for row, col, and box
        int n = 9;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                char cell = board[r][c];

                if (cell == '.') {
                    continue;
                }

                // Check row
                if (rows[r].contains(cell)) {
                    return false;
                }
                rows[r].add(cell);

                // Check column
                if (cols[c].contains(cell)) {
                    return false;
                }
                cols[c].add(cell);

                // Check 3x3 box
                int boxIndex = 3 * (r / 3) + (c / 3);
                if (boxes[boxIndex].contains(cell)) {
                    return false;
                }
                boxes[boxIndex].add(cell);
            }
        }

        return true;
    }
}