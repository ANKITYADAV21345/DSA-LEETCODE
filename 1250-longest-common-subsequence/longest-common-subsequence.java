//codebix
class Solution {

    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];

        // initialize memo with -1
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                memo[i][j] = -1;
            }
        }

        return lcs(text1, text2, 0, 0);
    }

    private int lcs(String s1, String s2, int i, int j) {

        // base case
        if (i == s1.length() || j == s2.length())
            return 0;

        // memo check
        if (memo[i][j] != -1)
            return memo[i][j];

        // recursive logic
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + lcs(s1, s2, i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(
                    lcs(s1, s2, i + 1, j),
                    lcs(s1, s2, i, j + 1)
            );
        }

        return memo[i][j];
    }
}
