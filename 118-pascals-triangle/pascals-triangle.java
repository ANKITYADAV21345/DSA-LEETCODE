

//tabulation
class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows][numRows];
        List<List<Integer>> result = new ArrayList<>();

        // Bottom-Up DP table fill
        for (int i = 0; i < numRows; i++) {
            dp[i][0] = 1; // first element of each row is 1

            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }

            dp[i][i] = 1; // last element of each row is 1

            // convert dp row to List for result
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(dp[i][j]);
            }
            result.add(row);
        }

        return result;
    }
}
