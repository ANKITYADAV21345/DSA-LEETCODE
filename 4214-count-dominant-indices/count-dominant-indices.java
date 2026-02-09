class Solution {
    public int dominantIndices(int[] nums) {
        
        double avg=0;
        double sum=0;
        int count=0;

        for(int i=0;i<=nums.length-2;i++){
            int n=nums.length-1-i;
            for(int j=i+1;j<=nums.length-1;j++){
                sum=sum+nums[j];
            }
            avg=sum/n;
            if(nums[i]>avg){
                count++;
            }
            sum=0;
        }
        return count;
    }
}