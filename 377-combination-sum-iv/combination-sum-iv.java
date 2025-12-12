//tabulation
import java.util.*;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;  // base case: one way to make target = 0

        for (int t = 1; t <= target; t++) {
            for (int num : nums) {
                if (num <= t) {
                    dp[t] += dp[t - num];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        int target = 4;

        int result = sol.combinationSum4(nums, target);
        System.out.println("Total combinations: " + result);
    }
}
