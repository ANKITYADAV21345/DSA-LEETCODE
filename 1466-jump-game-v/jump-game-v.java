class Solution {
    int [] dp;
    public int maxJumps(int[] arr, int d) {
        int max=0;
        dp=new int [arr.length];
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,countMaxJump(arr,i,d));
        }
        return max;
    }

    private int countMaxJump(int[] arr,int index,int d){
        if(dp[index]>0) return dp[index];
        int result=1;
        for(int j=index-1;j>=Math.max(index-d,0)&& arr[index]>arr[j];j--){
            result=Math.max(result,1+countMaxJump(arr,j,d));
        }
        for(int j=index+1;j<=Math.min(index+d,arr.length-1) && arr[index]>arr[j];j++){
            result=Math.max(result,1+countMaxJump(arr,j,d));
        }
        dp[index]=result;
        return result;
    } 
}