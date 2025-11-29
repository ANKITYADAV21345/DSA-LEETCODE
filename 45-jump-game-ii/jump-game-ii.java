//recursion +memoisatrion
class Solution {
    int[] memo;

    public int jump(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return solve(nums, 0);
    }

    private int solve(int[] nums, int i) {
        int n = nums.length;
        
        if (i == n - 1) return 0;
        if (nums[i] == 0) return (int)1e9; // unreachable
        
        if (memo[i] != -1) return memo[i];

        int steps = nums[i];
        int ans = (int)1e9;

        for (int j = i + 1; j <= i + steps && j < n; j++) {
            ans = Math.min(ans, 1 + solve(nums, j));
        }

        return memo[i] = ans;
    }
}
