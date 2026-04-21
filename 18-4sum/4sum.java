//APNA COLLEGE ARTICLE APROACH2

import java.util.*;


class Solution {
   public List<List<Integer>> fourSum(int[] nums, int target) {
       Set<List<Integer>> uniqueQuadruplets = new HashSet<>(); // To store unique quadruplets
       List<List<Integer>> result = new ArrayList<>();
       int n = nums.length;


       Arrays.sort(nums); // Sort the array


       // Fix first and second elements
       for (int i = 0; i < n - 3; i++) {
           for (int j = i + 1; j < n - 2; j++) {
               long val = (long)target - nums[i] - nums[j]; // Avoid overflow
               int low = j + 1, high = n - 1;


               // Two-pointer approach
               while (low < high) {
                   int sum = nums[low] + nums[high];


                   if (sum == val) {
                       uniqueQuadruplets.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                       low++;
                       high--;
                   }
                   else if (sum < val) {
                       low++; // Need larger sum
                   }
                   else {
                       high--; // Need smaller sum
                   }
               }
           }
       }


       result.addAll(uniqueQuadruplets); // Convert set to list
       return result;
   }


   // Main method
   public static void main(String[] args) {
       Solution sol = new Solution();
       int[] nums = {1, 0, -1, 0, -2, 2};
       int target = 0;
       List<List<Integer>> res = sol.fourSum(nums, target);


       for (List<Integer> quad : res) {
           System.out.println(quad);
       }
   }
}