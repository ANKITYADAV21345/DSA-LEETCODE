class Solution {
    public int maxSubArray(int[] nums) {
        
        //to find the maximum sum possible 
        int max_so_far = nums[0];

        //to store the maximum found at a position 
        int cur_max=nums[0];

        for(int i=1;i<nums.length;i++){

        //equivalent to step 3
        cur_max=Math.max(nums[i],nums[i]+ cur_max);

        //equivalent to step 4
        max_so_far=Math.max(cur_max,max_so_far);
        }
        return max_so_far;

    }
}