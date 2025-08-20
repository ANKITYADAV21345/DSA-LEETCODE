import java.util.*;

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //MAKE num1 as min length array
        //call same function and change the params
        //if nums1 was greater and nums2 was smaller 
        //so because e swaped these two now nums1 is smaller and 
        //nums2 is greater 
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int start = 0;
        int end = n1;
        int totalLength = n1 + n2;

        while (start <= end) {
            int cut1 = start + (end - start) / 2;
            int cut2 = (totalLength + 1) / 2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            // cheak if cut is valid
            if (l1 <= r2 && l2 <= r1) {
                //if total length is even only 2 ans is possible take avg
                if (totalLength % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    // total length is odd then 1 values
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                end = cut1 - 1;
            } else {
                start = cut1 + 1;
            }
        }

        // Should never reach here
        return 0.0;
    }

    // Sample usage
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2)); // Output: 2.0
    }
}
