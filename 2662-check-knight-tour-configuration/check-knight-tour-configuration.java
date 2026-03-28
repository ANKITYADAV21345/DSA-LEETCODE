//apna college 
import java.util.*;

public class Solution {

    public static boolean isValid(int[][] grid, int r, int c, int n, int expVal) {

        // out of bounds or wrong value
        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != expVal) {
            return false;
        }

        // last cell reached
        if (expVal == n * n - 1) {
            return true;
        }

        // 8 possible knight moves
        boolean ans1 = isValid(grid, r - 2, c + 1, n, expVal + 1);
        boolean ans2 = isValid(grid, r - 1, c + 2, n, expVal + 1);
        boolean ans3 = isValid(grid, r + 1, c + 2, n, expVal + 1);
        boolean ans4 = isValid(grid, r + 2, c + 1, n, expVal + 1);
        boolean ans5 = isValid(grid, r + 2, c - 1, n, expVal + 1);
        boolean ans6 = isValid(grid, r + 1, c - 2, n, expVal + 1);
        boolean ans7 = isValid(grid, r - 1, c - 2, n, expVal + 1);
        boolean ans8 = isValid(grid, r - 2, c - 1, n, expVal + 1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }

    public static boolean checkValidGrid(int[][] grid) {
        return isValid(grid, 0, 0, grid.length, 0);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 11, 16, 5, 20},
            {17, 4, 19, 10, 15},
            {12, 1, 8, 21, 6},
            {3, 18, 23, 14, 9},
            {24, 13, 2, 7, 22}
        };

        System.out.println(checkValidGrid(grid)); // true/false
    }
}