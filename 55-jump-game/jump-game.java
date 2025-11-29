//recursion+memoised
class Solution {
    Boolean[] memo;

    public boolean canJump(int[] nums) {
        memo = new Boolean[nums.length];
        return solve(nums, 0);
    }

    private boolean solve(int[] nums, int i) {
        int n = nums.length;

        // base case: reach last index
        if (i == n - 1) return true;

        // memo check
        if (memo[i] != null) return memo[i];

        int maxJump = nums[i];
        
        // try all possible jumps
        for (int j = i + 1; j <= i + maxJump && j < n; j++) {
            if (solve(nums, j)) {
                return memo[i] = true;
            }
        }

        return memo[i] = false;
    }
}
