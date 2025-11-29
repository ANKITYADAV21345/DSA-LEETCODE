// solve(i, j) → number of ways t[i..] can be formed from s[j..]

//recursion+memoisation
class Solution {

    int[][] memo;

    public int numDistinct(String s, String t) {
        memo = new int[t.length()][s.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(s, t, 0, 0);
    }

    private int solve(String s, String t, int i, int j) {
        // If t is fully matched
        if (i == t.length()) return 1;

        // If s is exhausted but t remains
        if (j == s.length()) return 0;

        // Check memo
        if (memo[i][j] != -1) return memo[i][j];

        int ways = 0;

        // Characters match → take OR skip
        if (t.charAt(i) == s.charAt(j)) {
            ways += solve(s, t, i + 1, j + 1);
        }

        // Skip s[j]
        ways += solve(s, t, i, j + 1);

        return memo[i][j] = ways;
    }
}


