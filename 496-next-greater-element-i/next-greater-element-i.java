//khud se kiya haio(n square) me
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int element = nums1[i];
            int indexInNums2 = -1;

            // nums2 me element ka index dhoondo
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == element) {
                    indexInNums2 = j;
                    break;
                }
            }

            // ab us index ke baad next greater dhoondo
            int nextGreater = -1;
            for (int k = indexInNums2 + 1; k < nums2.length; k++) {
                if (nums2[k] > element) {
                    nextGreater = nums2[k];
                    break;
                }
            }

            result[i] = nextGreater;
        }

        return result;
    }
}
