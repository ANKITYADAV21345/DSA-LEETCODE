//apna college
// Similar to 0/1 Knapsack,target sum

class Solution {
    public boolean canPartition(int[] nums) {

        int n = nums.length;

        // Step 1: Calculate total sum of array
        int totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum += nums[i];
        }

        // Step 2: Agar total sum odd hai to equal partition possible nahi
        if(totalSum % 2 != 0){
            return false;
        }

        // Step 3: Target subset sum
        int sum = totalSum / 2;

        // Step 4: DP array
        // dp[i][j] = using first i elements, can we make sum j?
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // Step 5: Base case
        // Sum = 0 hamesha possible hai (empty subset)
        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }

        // Step 6: Fill DP table
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){

                int val = nums[i - 1];

                // Include + Exclude
                if(val <= j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - val];
                }
                else{
                    // Only Exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Final answer
        return dp[n][sum];
    }
}