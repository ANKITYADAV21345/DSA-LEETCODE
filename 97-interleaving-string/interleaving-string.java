//code story with mik
class Solution {

    int m, n, N;
    int[][] dp;

    public boolean solve(int i, int j, String s1, String s2, String s3) {

        if (i == m && j == n && i + j == N) {
            return true;
        }

        if (i + j >= N) { // other string didn't get consumed completely
            return false;
        }

        if (dp[i][j] != -1) {
            if (dp[i][j] == 1) {
                return true;
            } else {
                return false;
            }
        }

        boolean result = false;

        if (i < m && s1.charAt(i) == s3.charAt(i + j)) {
            result = solve(i + 1, j, s1, s2, s3);
        }

        if (result) {
            dp[i][j] = 1;
            return true;
        }

        if (j < n && s2.charAt(j) == s3.charAt(i + j)) {
            result = solve(i, j + 1, s1, s2, s3);
        }

        if (result) {
            dp[i][j] = 1;
        } else {
            dp[i][j] = 0;
        }

        return result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        m = s1.length();
        n = s2.length();
        N = s3.length();

        dp = new int[101][101];

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, s1, s2, s3);
    }
}