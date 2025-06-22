class Solution {
    public int singleNumber(int[] nums) {
        
        //variable to store the xor result of the number 
        int single=nums[0];

        //start the loop for all elements 
        for (int i=1;i<nums.length;i++){
            single=single^nums[i];
        }

        return single;
    }
}