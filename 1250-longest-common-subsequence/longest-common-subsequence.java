//apna college tabulation
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();  // length of first string
        int m = text2.length();  // length of second string

        // Step 1: DP array
        // dp[i][j] = LCS length of first i chars of text1 and first j chars of text2
        int dp[][] = new int[n + 1][m + 1];

        // Step 2: Base case
        // already 0 by default in Java, but writing for clarity
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        // Step 3: Fill DP table
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){

                // if characters match
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    // if not match → take max of two possibilities
                    int ans1 = dp[i - 1][j];   // skip from text1
                    int ans2 = dp[i][j - 1];   // skip from text2

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        // final answer
        return dp[n][m];
    }
}