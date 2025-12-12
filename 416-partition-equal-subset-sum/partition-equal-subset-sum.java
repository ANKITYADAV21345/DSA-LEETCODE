
class Solution {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int x : nums) sum += x;

        // If total sum is odd → cannot partition equally
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        Boolean[][] dp = new Boolean[n][target + 1];

        return subsetSum(nums, 0, target, dp);
    }

    // Top-down recursion + memoization
    private boolean subsetSum(int[] nums, int i, int target, Boolean[][] dp) {

        // If target reached → valid subset
        if (target == 0) return true;

        // If no elements left or target < 0 → false
        if (i == nums.length || target < 0) return false;

        // Memo check
        if (dp[i][target] != null) return dp[i][target];

        // Choice 1: Take current element
        boolean take = subsetSum(nums, i + 1, target - nums[i], dp);

        // Choice 2: Skip current element
        boolean notTake = subsetSum(nums, i + 1, target, dp);

        return dp[i][target] = (take || notTake);
    }
}
