//study iq
import java.util.*;

class Solution {
    int MOD = 1000000007;

    public int numberOfPermutations(int n, int[][] requirements) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int[] r : requirements) {
            map.put(r[0], r[1]);
            max = Math.max(max, r[1]);
        }

        // Maximum possible inversions for n = n*(n-1)/2
        long[][] dp = new long[n][max + n + 1];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return (int) solve(0, n - 1, 0, map, dp);
    }

    private long solve(int idx, int lastIndex, int inversions, Map<Integer, Integer> map, long[][] dp) {
        if (idx == lastIndex) {
            return (!map.containsKey(idx) || map.get(idx) == inversions) ? 1 : 0;
        }

        if (dp[idx][inversions] != -1) return dp[idx][inversions];

        long ans = 0;
        for (int i = 0; i <= idx + 1; i++) {
            int newInversions = inversions + (idx + 1 - i);
            if (newInversions < dp[0].length &&
                (!map.containsKey(idx) || map.get(idx) == inversions)) {
                ans = (ans + solve(idx + 1, lastIndex, newInversions, map, dp)) % MOD;
            }
        }

        return dp[idx][inversions] = ans;
    }
}
