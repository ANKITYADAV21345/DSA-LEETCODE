//apna college article bruteforce
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;
        int[] freq = new int[N + 1]; // Frequency array
        // Initialise repeated and missing with -1
        int repeated = -1, missing = -1;

        // Count occurrences of each number in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

        // Find the repeated and missing numbers
        for (int i = 1; i <= N; i++) {
            if (freq[i] == 2) {
                repeated = i;
            } else if (freq[i] == 0) {
                missing = i;
            }
        }

        return new int[] { repeated, missing };
    }
}