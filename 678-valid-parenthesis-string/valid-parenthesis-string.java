//convert kiya hai recursion se dp
class Solution {

    public boolean checkValidString(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];

        // base case
        dp[n][0] = true;

        for (int index = n - 1; index >= 0; index--) {
            for (int open = 0; open <= n; open++) {

                char c = s.charAt(index);
                boolean valid = false;

                if (c == '(') {
                    if (open + 1 <= n)
                        valid = dp[index + 1][open + 1];
                }
                else if (c == ')') {
                    if (open - 1 >= 0)
                        valid = dp[index + 1][open - 1];
                }
                else { // '*'

                    // empty
                    valid = dp[index + 1][open];

                    // '('
                    if (!valid && open + 1 <= n)
                        valid = dp[index + 1][open + 1];

                    // ')'
                    if (!valid && open - 1 >= 0)
                        valid = dp[index + 1][open - 1];
                }

                dp[index][open] = valid;
            }
        }

        return dp[0][0];
    }
}
