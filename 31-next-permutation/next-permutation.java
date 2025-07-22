// input number 41532
// idx 1-> traverse from right  to left
//     a[i]<a[i+1]               idx 1=1
//     idx1=i
//     break

// idx 2-> traverse from right  to left
// a[idx1]<a[i]
// idx 2=i                        idx 2=4

// step 3 swap  a[idx1],a[idx2]

// step 4 sort(idx i+1 ot last index)

// step 5 agar sabse bada number enter hua hai to reverse kar do number



class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx1 = -1;
        
        // Step 1: Find the largest index idx1 such that nums[idx1] < nums[idx1 + 1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx1 = i;
                break;
            }
        }
        
        // Step 2: If no such index exists, the permutation is the last permutation
        // Reverse the entire array
        if (idx1 == -1) {
            reverse(nums, 0, n - 1);
        } else {
            // Step 3: Find the largest index idx2 such that nums[idx1] < nums[idx2]
            int idx2 = -1;
            for (int i = n - 1; i > idx1; i--) {
                if (nums[i] > nums[idx1]) {
                    idx2 = i;
                    break;
                }
            }
            
            // Step 4: Swap elements at idx1 and idx2
            swap(nums, idx1, idx2);
            
            // Step 5: Reverse the sequence from idx1 + 1 to the end
            reverse(nums, idx1 + 1, n - 1);
        }
    }
    
    // Helper method to reverse the array from index start to end
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    // Helper method to swap elements at indices i and j in the array nums
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
