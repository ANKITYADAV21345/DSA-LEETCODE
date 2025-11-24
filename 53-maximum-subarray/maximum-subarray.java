//done by own(recursion+tabulation)
class Solution {
    int[] memo;

    public int maxSubArray(int[] nums) {
        int n=nums.length;
        memo=new int[n];

        //initialize memo with special value
        for(int i=0;i<n;i++){
            memo[i]=Integer.MIN_VALUE;
        }

        int ans=nums[0];
        for(int i=0;i<n;i++){
            ans=Math.max(ans,solve(nums,i));
        }
        return ans;
    }

    public int solve(int [] nums,int i){
        //base case 
        if(i==0) return nums[0];

        if(memo[i]!=Integer.MIN_VALUE){
            return memo[i];
        }

        //logic
        int startNew=nums[i];
        int continuePrev=nums[i]+Math.max(0,solve(nums,i-1));
        return memo[i]=Math.max(startNew,continuePrev);
    }
}