//apna college notes dp solution 
class Solution {
    public int climbStairs(int n) {

        int dp[] = new int[n + 1];
        //eek bhi jump naji lagane ke 1 tarika 
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            
            //1 jump lagane ka bhi 1 tarika continue iss liye likha taki  dp[i] = dp[i - 1] + dp[i - 2];  ye line na chale i=1 le liye  
            if (i == 1) {
                dp[i] = dp[i - 1];
                continue;          
            }
            //2 ya use jyada jump lagane ke tarike  
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}