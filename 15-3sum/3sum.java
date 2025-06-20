import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if (n < 3) {
            // If there are less than 3 elements, return empty list as per invalid_inputs
            return result;
        }

        // Sort the array
        Arrays.sort(nums);

        // Fixing 1st element (n1)
        for (int i = 0; i < n ; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // Skip duplicate n1 to avoid duplicate triplet
                continue;
            }
            int n1 = nums[i];
            int target = -n1;

            // Use twoSum method to find n2 and n3
            twoSum(nums, target, i + 1, n - 1, result); // it will find n2 and n3; {n1, n2, n3}
        }
        return result;
    }

    // Method to find two numbers (n2 and n3) that sum up to target
    public void twoSum(int[] nums, int target, int i, int j, List<List<Integer>> result) {
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                // Found a triplet (n1, nums[i], nums[j])
                result.add(Arrays.asList(-target, nums[i], nums[j]));

                // Skip duplicates for nums[i]
                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                // Skip duplicates for nums[j]
                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }

                // Move both pointers inward
                i++;
                j--;
            }
        }
    }
}
