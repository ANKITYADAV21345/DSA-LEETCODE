//codebix
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;       // Boundary for 0s (all elements before left are 0s)
        int mid = 0;        // Current pointer being processed
        int right = nums.length - 1; // Boundary for 2s (all elements after right are 2s)

        while (mid <= right) { 
            if (nums[mid] == 0) {
                swap(nums, left, mid);
                left++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, right);
                right--;
            } else { // nums[mid] == 1
                mid++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}