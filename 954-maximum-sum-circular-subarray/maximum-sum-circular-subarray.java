class Solution {

    Integer[] memoMax;
    Integer[] memoMin;

    private int maxEndingAt(int[] nums, int i) {
        if (i == 0) return nums[0];
        if (memoMax[i] != null) return memoMax[i];

        memoMax[i] = Math.max(nums[i], nums[i] + maxEndingAt(nums, i - 1));
        return memoMax[i];
    }

    private int minEndingAt(int[] nums, int i) {
        if (i == 0) return nums[0];
        if (memoMin[i] != null) return memoMin[i];

        memoMin[i] = Math.min(nums[i], nums[i] + minEndingAt(nums, i - 1));
        return memoMin[i];
    }

    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;
        memoMax = new Integer[n];
        memoMin = new Integer[n];

        int maxSubarray = Integer.MIN_VALUE;
        int minSubarray = Integer.MAX_VALUE;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            maxSubarray = Math.max(maxSubarray, maxEndingAt(nums, i));
            minSubarray = Math.min(minSubarray, minEndingAt(nums, i));
            totalSum += nums[i];
        }

        if (totalSum == minSubarray) return maxSubarray;

        return Math.max(maxSubarray, totalSum - minSubarray);
    }
}

