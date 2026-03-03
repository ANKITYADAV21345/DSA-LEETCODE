//memoised code ko dp me convert kiya 5 steps ke through 
class Solution {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int x : nums) sum += x;

        if (sum % 2 != 0) return false;

        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int index = nums.length - 1; index >= 0; index--) {

            for (int currentTarget = 1; currentTarget <= target; currentTarget++) {

                boolean take = false;
                if (currentTarget - nums[index] >= 0)
                    take = dp[index + 1][currentTarget - nums[index]];

                boolean notTake = dp[index + 1][currentTarget];

                dp[index][currentTarget] = take || notTake;
            }
        }

        return dp[0][target];
    }
}
