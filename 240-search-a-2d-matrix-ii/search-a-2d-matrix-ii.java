class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start from the top-right corner of the matrix
        int row = 0;
        int col = matrix[0].length - 1;

        // Continue while within the bounds of the matrix
        while (row < matrix.length && col >= 0) {
            // Step 1: Check the current element
            if (matrix[row][col] == target) {
                return true; // Target found
            }
            // Step 2: If target is smaller than current element,
            // move left (decrease column)
            else if (target < matrix[row][col]) {
                col--;
            }
            // Step 3: If target is larger than current element,
            // move down (increase row)
            else {
                row++;
            }
        }

        // Step 4: If we exit the loop, target is not present
        return false;
    }
}
