//apna college  
//similar to 01 knapsack 
// maam ne iss questtion ko boolean me solve karaya hai

// s1-s2=target
// s1+s2=totalSum
// add both equation
// (s1-s2)+(s1+s2)=target+totalSum
// s1-s2+s1+s2=target+totalSum
// 2s1=target+totalSum
// s1=(target+totalSum)/2


class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;

        // Step 1: Calculate total sum of array
        int totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum += nums[i];
        }

        // Step 2: Check edge cases
        // Agar target achieve hi nahi ho sakta
        if(totalSum < Math.abs(target)){
            return 0;
        }

        // Agar (target + totalSum) odd hai → partition possible nahi
        if((target + totalSum) % 2 != 0){
            return 0;
        }

        // Step 3: Convert problem to subset sum
        // s1 = (target + totalSum) / 2
        int sum = (target + totalSum) / 2;

        // Step 4: DP array
        // dp[i][j] = number of ways to get sum j using first i elements
        int dp[][] = new int[n + 1][sum + 1];

        // Step 5: Base case
        // Sum = 0 banane ka 1 hi way hota hai (empty subset)
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }

        // Step 6: Fill DP table
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= sum; j++){

                int val = nums[i - 1]; // current element

                // Case 1: include + exclude
                if(val <= j){
                    // include (j - val) + exclude (j)
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - val];
                }
                else{
                    // Case 2: only exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Final answer: using all elements to form sum
        return dp[n][sum];
    }
}