//code story with mik aproach 1  with 3 variable 
// -1 -> not calculated
// 0  -> false
// 1  -> true


// Is solution me 3 variables (i, j, k) use kiye gaye hain, lekin k actually alag se rakhne ki zarurat nahi hai. Har recursive call me jab bhi i ya j ek step badhta hai, k bhi ek step badhta hai. Isliye hamesha:

// k = i + j

// hota hai.

// Isi wajah se is problem ka optimal memoization sirf 2D DP (dp[i][j]) se ho jata hai. Ye 3D solution sahi hai, lekin extra memory use karta hai. Competitive programming aur interviews me aam taur par 2D DP approach ko prefer kiya jata hai.



// solve(0,0,0)

//            |
//      a from s1
//            |
// solve(1,0,1)

//            |
//      c from s2
//            |
// solve(1,1,2)

//            |
//      b from s1
//            |
// solve(2,1,3)

//            |
//      d from s2
//            |
// solve(2,2,4)


class Solution {

    int m, n, N;
    int[][][] dp;

    public boolean solve(int i, int j, int k, String s1, String s2, String s3) {

        if (i == m && j == n && k == N) {
            return true;
        }

        if (k >= N) { // other string didn't get consumed completely
            return false;
        }

        if (dp[i][j][k] != -1) {
            return dp[i][j][k] == 1;
        }

        boolean result = false;

        if (i < m && s1.charAt(i) == s3.charAt(k)) {
            result = solve(i + 1, j, k + 1, s1, s2, s3);
        }

        if (result) {
            dp[i][j][k] = 1;
            return true;
        }

        if (j < n && s2.charAt(j) == s3.charAt(k)) {
            result = solve(i, j + 1, k + 1, s1, s2, s3);
        }

        if (result) {
            dp[i][j][k] = 1;
        } else {
            dp[i][j][k] = 0;
        }

        return result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        m = s1.length();
        n = s2.length();
        N = s3.length();

        dp = new int[101][101][201];

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                for (int k = 0; k <= 200; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(0, 0, 0, s1, s2, s3);
    }
}