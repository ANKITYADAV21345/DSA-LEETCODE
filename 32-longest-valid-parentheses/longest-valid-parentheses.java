//done by my own tabular
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int res = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                int prev = i - dp[i - 1] - 1;

                if (prev >= 0 && s.charAt(prev) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (prev - 1 >= 0) dp[i] += dp[prev - 1];
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
