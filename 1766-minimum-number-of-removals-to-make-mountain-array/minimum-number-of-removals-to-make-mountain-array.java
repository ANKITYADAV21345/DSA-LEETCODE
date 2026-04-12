//codestorywithmik

class Solution {

    public int minimumMountainRemovals(int[] nums) {

        int n = nums.length;

        int[] LIS = new int[n];
        int[] LDS = new int[n];

        // initialize with 1
        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
            LDS[i] = 1;
        }

        // calculate LIS
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }

        // calculate LDS
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }

        int minRemovals = n;

        // treat each index as peak
        for (int i = 0; i < n; i++) {

            // valid mountain condition
            if (LIS[i] > 1 && LDS[i] > 1) {
                minRemovals = Math.min(minRemovals, n - LIS[i] - LDS[i] + 1);
            }
        }

        return minRemovals;
    }
}