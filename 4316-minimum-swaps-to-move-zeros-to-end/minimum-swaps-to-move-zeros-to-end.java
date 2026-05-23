class Solution {
    public int minimumSwaps(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
            }

        }

        for(int i=nums.length-count;i<nums.length;i++){
            if(nums[i]==0){
                count--;
            }
        }
        return count;
    }
}