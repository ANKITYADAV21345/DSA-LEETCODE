public class Solution {
    public boolean canJump(int[] nums) {
        // Initialize the final position to the last index
        int finalPosition = nums.length - 1;

        // Traverse the array from second last index to the start
        for (int idx = nums.length - 2; idx >= 0; idx--) {
            // If we can reach the finalPosition from current index
            if (idx + nums[idx] >= finalPosition) {
                finalPosition = idx; // Update finalPosition to current index
            }
        }

        // If finalPosition is 0, then we can reach the end from the start
        return finalPosition == 0;
    }
}
