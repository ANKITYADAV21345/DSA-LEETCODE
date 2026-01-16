//study placement
class Solution {
    int arr[];
    public int climbStairs(int n, int[] costs) {
        int dp[]=new int [n+1];
        arr=new int[n+1];
        arr[0]=0;
        for(int i=1;i<=n;i++){
            arr[i]=costs[i-1];
        }

        dp[0]=0;
        dp[1]=cost(0,1);
        if(n==1){
            return dp[1];
        }

        dp[2]=Math.min(dp[1]+cost(1,2),cost(0,2));
        for(int i=3;i<=n;i++){
            int x=cost(i-1,i);
            int y=cost(i-2,i);
            int z=cost(i-3,i);
            dp[i]=Math.min(dp[i-1]+x,Math.min(dp[i-2]+y,dp[i-3]+z));
        }
        return dp[n];
    }

    public int cost(int i,int j){
        return arr[j]+((j-i)*(j-i));
    }
}