// Majority Element Finder
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length; // Length of the array
        int majority = -1; // Initialize result as -1 (default if no majority)

        // Loop through each element to check its frequency
        for (int i = 0; i < n; i++) {
            int count = 1; // Count starts at 1 (include current element)

            // Count occurrences of nums[i] in the rest of the array
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            // If count exceeds n/2, it's a majority element
            if (count > n / 2) {
                majority = nums[i];
            }
        }

        // Return the result (either the majority element or -1)
        return majority;
    }
}