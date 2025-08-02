//codebix + chatgpt 


import java.util.Arrays;

class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;

        // Ek naya array banate hain jisme hum 0 (start) aur n (end) bhi include karenge
        int[] newCuts = new int[c + 2];
        System.arraycopy(cuts, 0, newCuts, 1, c); // cuts ko index 1 se copy karo
        newCuts[0] = 0;      // stick ka starting point
        newCuts[c + 1] = n;  // stick ka ending point

        // Cuts ko sort karna zaroori hai taaki intervals sahi order me hoon
        Arrays.sort(newCuts);

        // 2D DP array banate hain: dp[i][j] = min cost to cut between newCuts[i] and newCuts[j]
        int[][] dp = new int[c + 2][c + 2];

        // len = interval ka size, 2 se shuru karenge kyunki kam se kam 3 points chahiye (start, cut, end)
        for (int len = 2; len < c + 2; len++) {
            for (int i = 0; i + len < c + 2; i++) {
                int j = i + len;

                // Initially, is interval ki cost max rakho, taaki minimum nikal sake
                dp[i][j] = Integer.MAX_VALUE;

                // Har possible cut point k ke liye check karo ki minimum cost kya aayegi
                for (int k = i + 1; k < j; k++) {
                    // Cost = left + right + cost of current cut (newCuts[j] - newCuts[i])
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + newCuts[j] - newCuts[i]);
                }
            }
        }

        // Final answer hoga stick ke 0 se n tak cut karne ki minimum cost
        return dp[0][c + 1];
    }
}
