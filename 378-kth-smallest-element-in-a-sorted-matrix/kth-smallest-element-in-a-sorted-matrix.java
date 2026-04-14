//techdose

class Solution {

    // upper_bound -> first index where element > target
    public int findUpperBound(int[] row, int target) {
        int left = 0, right = row.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (row[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int countLessOrEqual(int[][] matrix, int target) {
        int totalCount = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            int countInRow = findUpperBound(matrix[i], target);
            totalCount += countInRow;
        }

        return totalCount;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int lowValue = matrix[0][0];
        int highValue = matrix[n - 1][n - 1];

        while (lowValue < highValue) {
            int midValue = lowValue + (highValue - lowValue) / 2;

            int elementsCount = countLessOrEqual(matrix, midValue);

            if (elementsCount < k) {
                lowValue = midValue + 1;
            } else {
                highValue = midValue;
            }
        }

        return lowValue;
    }
}