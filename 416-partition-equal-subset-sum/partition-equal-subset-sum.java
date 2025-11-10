//apna college dp notes minimum partitioning

class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }

        int weight=sum/2;
        int dp[][]=new int[n+1][weight+1];

        //initialization step
        for(int i=0;i<n+1;i++){
            for(int j=0;j<weight+1;j++){
                dp[i][j]=0;
            }
        }


        //botom up uproach
        for(int i=1;i<n+1;i++){
            for(int j=1;j<weight+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=Math.max(nums[i-1]+dp[i-1][j-nums[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int sum1=dp[n][weight];
        int sum2=sum-sum1;
        if((sum1-sum2)==0){
            return true;
        }else{
            return false;
        }
    }
}
