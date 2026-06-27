//study placement recursion +memoised code hai apna college ka 
class Solution {
    Integer[][] dp;

    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (((target + sum) % 2 != 0) || (Math.abs(target) > sum)) {
            return 0;
        }

        int subsetSum = (target + sum) / 2;

        dp = new Integer[nums.length + 1][subsetSum + 1];

        return solve(nums, subsetSum, 0);
    }

    public int solve(int[] nums, int target, int idx) {

        if (idx == nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (target < 0) {
            return 0;
        }

        if (dp[idx][target] != null) {
            return dp[idx][target];
        }

        int include = solve(nums, target - nums[idx], idx + 1);
        int exclude = solve(nums, target, idx + 1);

        dp[idx][target] = include + exclude;
        return dp[idx][target];
    }
}