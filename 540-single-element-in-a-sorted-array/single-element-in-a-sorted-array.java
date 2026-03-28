//apna college
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // edge cases safe bana diye
            if (mid == 0) {
                if (nums[0] != nums[1]){
                    return nums[0];
                }
                else{
                    start = mid + 1;
                }
                continue;
            }
            if (mid == n - 1) {
                if (nums[n - 1] != nums[n - 2]){
                    return nums[n - 1];
                }
                else{
                    end = mid - 1;
                }
                continue;
            }

            //unique element 
            if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            //binary logic
            if (mid % 2 == 0) { // even index
                if (nums[mid] == nums[mid + 1]) {
                    start = mid + 2;
                } else {
                    end = mid - 1;
                }
            } else { // odd index
                if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}