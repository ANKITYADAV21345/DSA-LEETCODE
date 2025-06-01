class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Filter out invalid numbers
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Mark the presence of elements
        for (int i = 0; i < n; i++) {
            int element = Math.abs(nums[i]);
            if (element >= 1 && element <= n) {
                int seat = element - 1;
                if (nums[seat] > 0) {
                    nums[seat] = -nums[seat];
                }
            }
        }

        // Step 3: Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // If all numbers 1 to n are present
        return n + 1;
    }
}
