import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countPairs(nums, mid);

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countPairs(int[] nums, int maxDistance) {
        int count = 0;
        int n = nums.length;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && nums[j] - nums[i] <= maxDistance) {
                j++;
            }
            count += (j - i - 1); // j is now one past the valid range
        }

        return count;
    }
}
