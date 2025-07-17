//nikhil lohia
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] T = new int[n];
        Arrays.fill(T, 1);  // Each element is an LIS of length 1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    T[i] = Math.max(T[i], T[j] + 1);
                }
            }
        }

        // Find the maximum value in T
        int maxLen = 0;
        for (int len : T) {
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
