//apna college article
//optimised
import java.util.*;  // Import utilities


class Solution {
   // Function to calculate the maximum area of water container
   public int maxArea(int[] height) {
       int n = height.length;
       int maxWater = 0;
       int left = 0, right = n - 1; // Initialize two pointers


       // Continue until pointers meet
       while (left < right) {
           int width = right - left; // Width between lines
           int minHeight = Math.min(height[left], height[right]); // Height is min of two lines
           maxWater = Math.max(maxWater, width * minHeight); // Update max area


           // Move the pointer pointing to the smaller height
           if (height[left] < height[right])
               left++;
           else
               right--;
       }


       return maxWater;
   }


   public static void main(String[] args) {
       Solution sol = new Solution();
       int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7}; // Input array
       int result = sol.maxArea(height); // Call function
       System.out.println("Maximum water that can be stored: " + result);
   }
}



