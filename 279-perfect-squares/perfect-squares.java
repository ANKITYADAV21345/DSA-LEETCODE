// CodeBix: Bottom-Up DP (Tabulation)
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        
        // Initially set dp[i] = max possible count (i.e., all 1^2 used)
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }
        
        return dp[n];
    }
}
