import java.util.*;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        return recur(target, nums, new ArrayList<>(), dp);
    }

    public int recur(int target, int[] nums, ArrayList<Integer> cur, HashMap<Integer, Integer> dp) {
        // Base cases
        if (target == 0) {
            // Uncomment below to print valid combinations
            // System.out.println(cur);
            return 1;
        }
        if (target < 0) return 0;

        // Memoization check
        if (dp.containsKey(target)) {
            return dp.get(target);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                cur.add(nums[i]); // add number to current combination
                res += recur(target - nums[i], nums, cur, dp); // recurse
                cur.remove(cur.size() - 1); // backtrack
            }
        }

        dp.put(target, res); // memoize result
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        int target = 4;
        int result = sol.combinationSum4(nums, target);
        System.out.println("Total combinations: " + result);
    }
}