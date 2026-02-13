class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int one_Count=0;
        int max_Count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                one_Count++;
                max_Count=Math.max(max_Count,one_Count);
            }
            else if(nums[i]==0){
                one_Count=0;
            }
        }
        return max_Count;
    }
}