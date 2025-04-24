import java.util.*;

public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums); // Sort the array

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates

                int p = j + 1, q = n - 1;

                while (p < q) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[p] + (long) nums[q];

                    if (sum < target) {
                        p++;
                    } else if (sum > target) {
                        q--;
                    } else { // sum == target
                        ans.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        p++;
                        q--;

                        // Skip duplicates
                        while (p < q && nums[p] == nums[p - 1]) p++;
                        while (p < q && nums[q] == nums[q + 1]) q--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = fourSum(nums, target);
        System.out.println(result);
    }
}