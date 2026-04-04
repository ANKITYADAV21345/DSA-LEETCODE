//codestorywith mik

import java.util.*;

class Solution {

    static int[][] dp;

    static int solve(int l, int r, String s) {

        // base cases
        if (l == r) return 1;
        if (l > r) return 0;

        if (dp[l][r] != -1) return dp[l][r];

        int i = l + 1;

        // skip same characters
        while (i <= r && s.charAt(i) == s.charAt(l)) {
            i++;
        }

        // if all characters same
        if (i == r + 1) return dp[l][r] = 1;

        // case 1: print separately
        int basic = 1 + solve(i, r, s);

        // case 2: merge same characters
        int lalach = Integer.MAX_VALUE;

        for (int j = i; j <= r; j++) {
            if (s.charAt(j) == s.charAt(l)) {
                int ans = solve(i, j - 1, s) + solve(j, r, s);
                lalach = Math.min(lalach, ans);
            }
        }

        return dp[l][r] = Math.min(basic, lalach);
    }

    public static int strangePrinter(String s) {
        int n = s.length();
        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, n - 1, s);
    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(strangePrinter(s)); // output: 2
    }
}