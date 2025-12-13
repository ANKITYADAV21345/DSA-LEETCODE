import java.util.*;

class Solution {

    // Memoization map
    Map<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, 0, target);
    }

    private int solve(int[] nums, int index, int currSum, int target) {

        // Base case
        if (index == nums.length) {
            return currSum == target ? 1 : 0;
        }

        // Create unique key for memo
        String key = index + "," + currSum;

        // If already computed
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Choose + and -
        int add = solve(nums, index + 1, currSum + nums[index], target);
        int subtract = solve(nums, index + 1, currSum - nums[index], target);

        int totalWays = add + subtract;

        // Store result in memo
        memo.put(key, totalWays);

        return totalWays;
    }
}
