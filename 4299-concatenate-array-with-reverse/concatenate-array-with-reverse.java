class Solution {
    public int[] concatWithReverse(int[] nums) {
        int [] result=new int[2*(nums.length)];
        int j=0;
        for(int i=0;i<nums.length;i++){
            result[j]=nums[i];
            j++;
        }

        for(int i=nums.length-1;i>=0;i--){
            result[j]=nums[i];
            j++;
        }
        return result;
    }
}