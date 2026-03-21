//algo daily
//21=03-2026 
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int startR = x;
        int endR = x + k - 1;

        while (startR < endR) {
            for (int i = y; i < y + k; i++) {
                int temp = grid[startR][i];
                grid[startR][i] = grid[endR][i];
                grid[endR][i] = temp;
            }
            startR++;
            endR--;
        }

        return grid;
    }
}