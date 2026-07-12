//apnacollege yt 
class Solution {

    boolean searchinrow(int[][] matrix, int target, int row) {
        int n = matrix[0].length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {   // Fixed
            int mid = start + (end - start) / 2;

            if (target == matrix[row][mid]) {
                return true;
            } else if (target > matrix[row][mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int startrow = 0;
        int endrow = m - 1;

        while (startrow <= endrow) {
            int midrow = startrow + (endrow - startrow) / 2;

            if (target >= matrix[midrow][0] && target <= matrix[midrow][n - 1]) {
                return searchinrow(matrix, target, midrow);
            } else if (target > matrix[midrow][n - 1]) {   // Fixed
                startrow = midrow + 1;
            } else {
                endrow = midrow - 1;
            }
        }

        return false;
    }
}