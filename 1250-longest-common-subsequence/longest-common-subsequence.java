// apna college
//recursion+memo
class Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        // Step 1: memo array
        // memo[i][j] = LCS length of first i chars of text1 and first j chars of text2
        int[][] memo = new int[n + 1][m + 1];

        // initialize with -1 (means not computed)
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                memo[i][j] = -1;
            }
        }

        return LCS(text1, text2, n, m, memo);
    }

    public int LCS(String text1, String text2, int n, int m, int[][] memo){

        // Step 2: Base case
        // agar koi string empty hai → LCS = 0
        if(n == 0 || m == 0){
            return 0;
        }

        // Step 3: check memo (already computed)
        if(memo[n][m] != -1){
            return memo[n][m];
        }

        // Step 4: if characters match
        if(text1.charAt(n - 1) == text2.charAt(m - 1)){
            memo[n][m] = 1 + LCS(text1, text2, n - 1, m - 1, memo);
        } 
        else{
            // Step 5: if not match → take max of two choices
            int ans1 = LCS(text1, text2, n - 1, m, memo);
            int ans2 = LCS(text1, text2, n, m - 1, memo);

            memo[n][m] = Math.max(ans1, ans2);
        }

        return memo[n][m];
    }
}