import java.util.*;

class Solution {

    int[][] pairs;
    int[] memo;

    public int findLongestChain(int[][] pairs) {

        // Sort pairs by first element (same as DP version)
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        this.pairs = pairs;
        int n = pairs.length;

        memo = new int[n];
        Arrays.fill(memo, -1);

        int maxChain = 1;
        for (int i = 0; i < n; i++) {
            maxChain = Math.max(maxChain, solve(i));
        }

        return maxChain;
    }

    // longest chain ending at index i
    private int solve(int i) {

        // already computed
        if (memo[i] != -1)
            return memo[i];

        int best = 1; // base case

        for (int j = 0; j < i; j++) {
            if (pairs[j][1] < pairs[i][0]) {
                best = Math.max(best, solve(j) + 1);
            }
        }

        memo[i] = best;
        return best;
    }
}
