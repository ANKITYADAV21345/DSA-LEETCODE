//sanyam IIT Guwahati
class Solution {
    public int minXor(int[] nums, int k) {
        int n = nums.length;

        int[] prefixXor = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ nums[i - 1];
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefixXor[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(k, i); j++) {
                for (int t = 1; t <= i - 1; t++) {
                    if (dp[t][j - 1] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(
                            dp[i][j],
                            Math.max(dp[t][j - 1], prefixXor[i] ^ prefixXor[t])
                        );
                    }
                }
            }
        }

        return dp[n][k];
    }
}

