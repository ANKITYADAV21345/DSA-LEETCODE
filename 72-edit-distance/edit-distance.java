// solve(i, j) → minimum operations to convert
//              word1[0..i] → word2[0..j]

//recursion+tabular
class Solution {
    int[][] memo;

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        memo = new int[n][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(word1, word2, n - 1, m - 1);
    }

    private int solve(String w1, String w2, int i, int j) {
        // Base cases
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        // Memo check
        if (memo[i][j] != -1) return memo[i][j];

        // Characters match → no new operation
        if (w1.charAt(i) == w2.charAt(j)) {
            return memo[i][j] = solve(w1, w2, i - 1, j - 1);
        }

        // Mismatch → try all 3 operations
        int insert = solve(w1, w2, i, j - 1) + 1;
        int del = solve(w1, w2, i - 1, j) + 1;
        int replace = solve(w1, w2, i - 1, j - 1) + 1;

        return memo[i][j] = Math.min(insert, Math.min(del, replace));
    }
}

