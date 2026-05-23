class Solution {
    public int minimumSwaps(int[] nums) {
        int count =0;
        int i=0;
        int j=nums.length-1;
        
        while(i<j){
            //last cheak
            if(nums[j]==0){
                j--;
            }

            //swaping 
            else if(nums[i]==0 && nums[j]!=0){
                count++;
                i++;
                j--;
            }
            
            //non zero
            else{
                i++;
            }
        }
        return count;
    }
}