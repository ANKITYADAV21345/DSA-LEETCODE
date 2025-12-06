class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        // dpMax[i] = maximum product of subarray ending at index i
        // dpMin[i] = minimum product of subarray ending at index i
        //
        // Negative number multiply hote hi role swap ho sakta hai:
        // min → max, max → min

        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int curr = nums[i];

            // Three possibilities:
            // 1️⃣ Current number alone
            // 2️⃣ Current × previous max product
            // 3️⃣ Current × previous min product
            dpMax[i] = Math.max(curr, Math.max(curr * dpMax[i - 1], curr * dpMin[i - 1]));
            dpMin[i] = Math.min(curr, Math.min(curr * dpMax[i - 1], curr * dpMin[i - 1]));

            ans = Math.max(ans, dpMax[i]);
        }

        return ans;
    }
}
