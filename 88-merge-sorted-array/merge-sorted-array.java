//apna college  bruteforce article

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
           // Copy elements from nums2 to nums1 starting from index m
           for (int i = m; i < m + n; i++) {
               nums1[i] = nums2[i - m];
           }
           // Sort the merged array
           Arrays.sort(nums1);
       }
}