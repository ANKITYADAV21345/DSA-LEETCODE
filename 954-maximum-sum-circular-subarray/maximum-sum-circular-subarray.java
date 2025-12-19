class Solution {

    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;

        // ---------- TABULATION : MAX SUBARRAY ----------
        int[] maxDp = new int[n];
        maxDp[0] = nums[0];
        int maxSubarraySum = nums[0];

        for (int i = 1; i < n; i++) {
            maxDp[i] = Math.max(nums[i], maxDp[i - 1] + nums[i]);
            maxSubarraySum = Math.max(maxSubarraySum, maxDp[i]);
        }

        // ---------- TABULATION : MIN SUBARRAY ----------
        int[] minDp = new int[n];
        minDp[0] = nums[0];
        int minSubarraySum = nums[0];

        for (int i = 1; i < n; i++) {
            minDp[i] = Math.min(nums[i], minDp[i - 1] + nums[i]);
            minSubarraySum = Math.min(minSubarraySum, minDp[i]);
        }

        // ---------- TOTAL SUM ----------
        int totalSum = 0;
        for (int val : nums) {
            totalSum += val;
        }

        // ---------- EDGE CASE ----------
        // when all numbers are negative
        if (totalSum == minSubarraySum) {
            return maxSubarraySum;
        }

        // ---------- FINAL ANSWER ----------
        int circularSubarraySum = totalSum - minSubarraySum;
        return Math.max(maxSubarraySum, circularSubarraySum);
    }
}
